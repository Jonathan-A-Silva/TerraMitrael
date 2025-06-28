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
import model.entities.persistence.encryption.Encryption;
import model.entities.persistence.image.Image;
import model.entities.persistence.user.User;
import model.enums.Materials.Presence;
import util.ResponseJson;

@MultipartConfig
@WebServlet(urlPatterns = {"/edit-profile", "/home", "/login", "/login-user", "/logout", "/register", "/register-user", "/profile"})
public class UserServlet extends HttpServlet {

    private final Gson json = new Gson();

    private EncryptionDAO encryptionDAO;
    private ImageDAO imageDAO;
    private UserDAO userDAO;

    public void init() {
        encryptionDAO = new EncryptionDAOImpl();
        imageDAO = new ImageDAOImpl();
        userDAO = new UserDAOImpl();
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
        String email_nick = request.getParameter("nickname");
        String password = request.getParameter("password");

        ResponseJson responseJson;

        if (email_nick == null || email_nick.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            responseJson = new ResponseJson(false, "Você precisa preencher as credenciais.");
        } else {
            User user = null;
            User loginUser = null;

            try {
                user = userDAO.getUserForNickname(email_nick);

                if (user == null) {
                    user = userDAO.getUserForEmail(email_nick);
                }

                Encryption encryption = encryptionDAO.getEncryptionByUserId(user.getId());

                loginUser = new User(user.getEmail(), user.getNickname(), password, encryption);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (loginUser.credentialsEquals(user)) {
                HttpSession session = request.getSession();
                user.setEncryption(null);
                session.setAttribute("User", user);
                responseJson = new ResponseJson(true);
            } else {
                responseJson = new ResponseJson(false, "Credenciais inválidas.");
            }

        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJson(responseJson));
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
        Encryption encryption = new Encryption();

        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");


        User user = new User(email, nickname, password, encryption);

        ResponseJson responseJson;

        if (nickname == null || nickname.trim().isEmpty() || password == null || password.length() < 6) {
            responseJson = new ResponseJson(false, "Nickname e password são obrigatórios e a password deve conter pelo menos 6 caracteres.");
        } else {
            try {
                userDAO.saveUser(user);
                responseJson = new ResponseJson(true);
            } catch (PersistenceException e) {
                responseJson = new ResponseJson(false, "Nickname já em uso.");
            } catch (Exception e) {
                responseJson = new ResponseJson(false, "Erro inesperado.");
            }
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJson(responseJson));

    }

    private void profileEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        User user = null;

        if (session != null && session.getAttribute("User") != null) {
            user = (User) session.getAttribute("User");
        }

        if (user == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            dispatcher.forward(request, response);
        } else {
            Part filePart = request.getPart("profile-image");
            String nickname = request.getParameter("profile-nickname");
            User profile_user = userDAO.getUserForNickname(nickname);
            ResponseJson responseJson;

            if (user.credentialsEquals(profile_user)) {
                user = userDAO.getUserForId(user.getId());

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
                    password_edit = user.getPassword();
                }

                Encryption encryption = encryptionDAO.getEncryptionByUserId(user.getId());

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
                session.setAttribute("User", user);

                responseJson = new ResponseJson(true, "Perfil Editado.");
                response.getWriter().write(json.toJson(responseJson));

            }

        }

    }

    private void profileUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");

        User user = userDAO.getUserForNickname(nickname);

        request.setAttribute("userprofile", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(request, response);
    }
}
