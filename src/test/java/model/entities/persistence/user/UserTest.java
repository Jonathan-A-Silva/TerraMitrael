package model.entities.persistence.user;

import model.dao.user.UserDAO;
import model.dao.user.UserDAOImpl;
import model.entities.persistence.encryption.Encryption;
import model.enums.Presence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void test() {
        UserDAO userDAO = new UserDAOImpl();
        Encryption encryption = new Encryption();
        User user = new User("teste@email.com", "teste", "teste", encryption);
        userDAO.saveUser(user);
        user = userDAO.getUserForId(user.getId());
        user.setNickname("alterado");
        user.setPresence(Presence.DO_NOT_DISTURB);
        userDAO.updateUser(user);
        assertTrue(true);
    }
}