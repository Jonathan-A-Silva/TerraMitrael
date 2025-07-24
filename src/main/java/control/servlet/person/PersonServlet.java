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
import model.dao.entity.EntityDAO;
import model.dao.entity.EntityDAOImpl;
import model.dao.person.PersonDAO;
import model.dao.person.PersonDAOImpl;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.entities.persistence.entity.PersistenceEntity;
import model.entities.persistence.person.Person;
import model.entities.persistence.user.User;
import model.enums.EntityClass;
import model.enums.Race;
import model.exceptions.person.InvalidPersonException;
import util.web.ResponseJson;
import util.web.SessionValidator;
import util.web.Validator;

@WebServlet(urlPatterns = {"/register-person", "/register-user-person"})
public class PersonServlet extends HttpServlet {

    private final Gson json = new Gson();

    private EncryptionDAO encryptionDAO;
    private EntityDAO entityDAO;
    private PersonDAO personDAO;
    private UserDAO userDAO;

    public void init() {
        encryptionDAO = new EncryptionDAOImpl();
        entityDAO = new EntityDAOImpl();
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
                case "/register-person" -> registerPersonPage(request, response);
                case "/register-user-person" -> registerPerson(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!SessionValidator.isUserLoggedIn(request)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            dispatcher.forward(request, response);
        }

        String first_name = request.getParameter("first-name");
        String last_name = request.getParameter("last-name");
        EntityClass classe = EntityClass.valueOf(request.getParameter("person-classe"));
        Race race = Race.valueOf(request.getParameter("person-race"));
        User user = SessionValidator.getLoggedUser(request);
        ResponseJson responseJson;

        try {
            Validator.validatePersonRegistration(first_name, classe, race);

            PersistenceEntity entity = new PersistenceEntity(first_name, classe, race);
            Person person = new Person(first_name, last_name, entity, user);

            user.setPersons(personDAO.getPersonForUserId(user.getId()));
            user.addPerson(person);

            entityDAO.savePersistenceEntity(entity);
            personDAO.savePerson(person);
            userDAO.updateUser(user);

            responseJson = new ResponseJson(true);
        } catch (InvalidPersonException personException) {
            responseJson = new ResponseJson(false, personException.getMessage());
        } catch (Exception exception){
            responseJson = new ResponseJson(false, "Erro Inesperado.");
        }

        sendJsonResponse(response, responseJson);
    }

    private void registerPersonPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!SessionValidator.isUserLoggedIn(request)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            dispatcher.forward(request, response);
        }

        request.setAttribute("classes", EntityClass.values());
        request.setAttribute("races", Race.values());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/register-person.jsp");
        dispatcher.forward(request, response);

    }

    private void sendJsonResponse(HttpServletResponse response, ResponseJson responseJson) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJson(responseJson));
    }

}
