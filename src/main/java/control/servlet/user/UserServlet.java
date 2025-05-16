package control.servlet.user;

import java.io.IOException;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.entities.persistence.user.User;
import org.mindrot.jbcrypt.BCrypt;
import util.ResponseJson;

@WebServlet(urlPatterns = {"/home", "/login", "/login-user", "/logout", "/register", "/register-user", "/profile"})
public class UserServlet extends HttpServlet {

    private final Gson json = new Gson();

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
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
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        ResponseJson responseJson;

        if (nickname == null || nickname.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            responseJson = new ResponseJson(false, "Você precisa preencher as credenciais.");
        } else {
            User user = userDAO.getUserForNickname(nickname);

            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("User", user);
                responseJson = new ResponseJson(true, "Login validado com sucesso.");
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

        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(nickname, hashedPassword);

        ResponseJson responseJson;

        if (nickname == null || nickname.trim().isEmpty() || password == null || password.length() < 6) {
            responseJson = new ResponseJson(false, "Nickname e password são obrigatórios. A password deve ter pelo menos 6 caracteres.");
        } else {
            try {
                userDAO.saveUser(user);
                responseJson = new ResponseJson(true, "Cadastro validado com sucesso.");
            } catch (PersistenceException e) {
                responseJson = new ResponseJson(false, "Nickname já em uso.");
            }
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJson(responseJson));

    }

    private void profileUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");

        User user = userDAO.getUserForNickname(nickname);

        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(request, response);
    }
}
