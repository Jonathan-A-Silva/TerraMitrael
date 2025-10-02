package control.servlet.user;

import java.io.IOException;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import model.dao.encryption.EncryptionDAO;
import model.dao.encryption.EncryptionDAOImpl;
import model.dao.image.ImageDAO;
import model.dao.image.ImageDAOImpl;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.persistence.encryption.Encryption;
import model.persistence.image.Image;
import model.persistence.user.User;
import model.exceptions.user.InvalidUserException;
import model.service.UserService;
import util.web.ResponseJson;
import util.web.SessionValidator;
import util.web.Validator;

@MultipartConfig
@WebServlet(urlPatterns = {"/edit-profile", "/home", "/login", "/login-user", "/logout", "/register", "/register-user", "/profile"})
public class UserServlet extends HttpServlet {

    private final Gson json = new Gson();

    private EncryptionDAO encryptionDAO;
    private ImageDAO imageDAO;
    private UserDAO userDAO;
    private UserService userService;

    public void init() {
        encryptionDAO = new EncryptionDAOImpl();
        imageDAO = new ImageDAOImpl();
        userDAO = new UserDAOImpl();
        userService = new UserService(userDAO, imageDAO, encryptionDAO);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/edit-profile" -> profileEdit(request, response);
                case "/home" -> homePage(request, response);
                case "/login" -> loginPage(request, response);
                case "/login-user" -> loginUser(request, response);
                case "/logout" -> logout(request, response);
                case "/register" -> registerPage(request, response);
                case "/register-user" -> registerUser(request, response);
                case "/profile" -> profileUser(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/home.jsp");
        dispatcher.forward(request, response);
    }

    private void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
        dispatcher.forward(request, response);
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String emailOrNickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        ResponseJson responseJson;

        try {
            Validator.validateLoginCredentials(emailOrNickname, password);
            User user = userService.authenticateUser(emailOrNickname, password);
            if (user != null) {
                SessionValidator.setLoggedUser(request, user);
                responseJson = new ResponseJson(true);
            } else {
                responseJson = new ResponseJson(false, "Credenciais inválidas.");
            }

        } catch (InvalidUserException e) {
            responseJson = new ResponseJson(false, e.getMessage());
        } catch (PersistenceException e) {
            responseJson = new ResponseJson(false, "Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (Exception e) {
            responseJson = new ResponseJson(false, "Erro inesperado: " + e.getMessage());
        }

        sendJsonResponse(response, responseJson);

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath());
    }

    private void registerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/register.jsp");
        dispatcher.forward(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        ResponseJson responseJson;

        try {
            User user = new User(email, nickname, password, new Encryption());
            Validator.validateRegistration(user);
            userDAO.saveUser(user);
            responseJson = new ResponseJson(true);
        } catch (InvalidUserException e) {
            responseJson = new ResponseJson(false, e.getMessage());
        } catch (PersistenceException e) {
            responseJson = new ResponseJson(false, "Nickname já em uso.");
        } catch (Exception e) {
            responseJson = new ResponseJson(false, "Erro inesperado: " + e.getMessage());
        }
        sendJsonResponse(response, responseJson);
    }

    private void profileEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!SessionValidator.isUserLoggedIn(request)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            dispatcher.forward(request, response);
        } else {
            Part filePart = request.getPart("profile-image");
            String nickname = request.getParameter("profile-nickname");
            User profile_user = userDAO.getUserForNickname(nickname);
            User user = SessionValidator.getLoggedUser(request);
            ResponseJson responseJson;

            if (user.credentialsEquals(profile_user)) {
                user = userDAO.getUserForId(user.getId());
                Encryption encryption = encryptionDAO.getEncryptionByUserId(user.getId());

                user.setEncryption(encryption);

                String email_edit = request.getParameter("profile-email-edit");
                String nickname_edit = request.getParameter("profile-nickname-edit");
                String password_edit = request.getParameter("profile-password-edit");

                if (email_edit == null || email_edit.isBlank()) {
                    email_edit = user.getEmail();
                }

                if (nickname_edit == null || nickname_edit.isBlank()) {
                    nickname_edit = user.getNickname();
                }

                if (password_edit == null || password_edit.isBlank()) {
                    password_edit = user.getDecryptPassword();
                }

                encryption = new Encryption(encryption.getId());

                user.setEncryption(encryption);
                user.setEmail(email_edit);
                user.setNickname(nickname_edit);
                user.setPassword(password_edit);

                if (filePart != null && filePart.getSize() > 0) {
                    byte[] imagem = filePart.getInputStream().readAllBytes();
                    String tipo = filePart.getContentType();

                    Image imagemExistente = imageDAO.getImageForUserNickname(user.getNickname());

                    if (imagemExistente != null) {
                        imagemExistente.setImage(imagem);
                        imagemExistente.setType(tipo);
                        user.setImage(imagemExistente);
                        imageDAO.updateImage(imagemExistente);
                    } else {
                        Image novaImage = new Image(imagem, tipo, user);
                        user.setImage(novaImage);
                        imageDAO.saveImage(novaImage);
                    }
                }

                userDAO.updateUser(user);
                SessionValidator.setLoggedUser(request, user);

                responseJson = new ResponseJson(true, "Perfil Editado.");
                response.getWriter().write(json.toJson(responseJson));

            }

        }

    }

    private void profileUser(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String nickname = request.getParameter("nickname");

        User user = userDAO.getUserForNickname(nickname);

        request.setAttribute("userprofile", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(request, response);
    }

    private void sendJsonResponse(HttpServletResponse response, ResponseJson responseJson) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJson(responseJson));
    }

}
