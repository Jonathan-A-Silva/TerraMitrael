package control.servlet.person;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import model.dao.encryption.EncryptionDAO;
import model.dao.encryption.EncryptionDAOImpl;
import model.dao.person.PersonDAO;
import model.dao.person.PersonDAOImpl;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.enums.EntityClass;
import model.enums.Race;

@WebServlet(urlPatterns = {"/register-person"})
public class PersonServlet extends HttpServlet {

    private final Gson json = new Gson();

    private EncryptionDAO encryptionDAO;
    private PersonDAO personDAO;
    private UserDAO userDAO;

    public void init() {
        encryptionDAO = new EncryptionDAOImpl();
        personDAO = new PersonDAOImpl();
        userDAO = new UserDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/register-person" -> RegisterPerson(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void RegisterPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("classes", EntityClass.values());
        request.setAttribute("races", Race.values());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/register-person.jsp");
        dispatcher.forward(request, response);
    }

}
