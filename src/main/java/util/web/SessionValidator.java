package util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.persistence.user.User;
import model.exceptions.user.InvalidUserException;

public class SessionValidator {

    private static final UserDAO userDAO = new UserDAOImpl();

    public static User validateLoggedInUser(HttpServletRequest request) throws InvalidUserException {
        HttpSession session = request.getSession(false);

        if (session == null) {
            throw new InvalidUserException("Nenhuma sessão ativa encontrada.");
        }

        User user = (User) session.getAttribute("User");

        if (user == null) {
            throw new InvalidUserException("Usuário não está logado.");
        }

        return user;
    }

    public static boolean isUserLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("User") != null;
    }

    public static User getLoggedUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = null;
        if (session != null && session.getAttribute("User") != null) {
            User webUser = (User) session.getAttribute("User");
            try {
                user = userDAO.getUserForId(webUser.getId());
                if (!user.credentialsEquals(webUser)) {
                    user = null;
                }
            } catch (Exception e) {
                user = null;
            }
        }
        return user;
    }

    public static void setLoggedUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession(true);
        user.setEncryption(null);
        session.setAttribute("User", user);
    }

}
