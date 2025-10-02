package model.service;

import javax.persistence.PersistenceException;

import model.dao.encryption.EncryptionDAO;
import model.dao.image.ImageDAO;
import model.dao.user.UserDAO;
import model.persistence.encryption.Encryption;
import model.persistence.user.User;
import util.web.Validator;

    public class UserService {
        private final UserDAO userDAO;
        private final ImageDAO imageDAO;
        private final EncryptionDAO encryptionDAO;

        public UserService(UserDAO userDAO, ImageDAO imageDAO, EncryptionDAO encryptionDAO) {
            this.userDAO = userDAO;
            this.imageDAO = imageDAO;
            this.encryptionDAO = encryptionDAO;
        }

    public User authenticateUser(String emailOrNickname, String password) throws PersistenceException {
        User user = userDAO.getUserForNickname(emailOrNickname);

        if (user == null) {
            user = userDAO.getUserForEmail(emailOrNickname);
        }

        if (user == null) {
            return null;
        }

        Encryption encryption = encryptionDAO.getEncryptionByUserId(user.getId());
        User loginUser = new User(user.getEmail(), user.getNickname(), password, encryption);

        if (Validator.validateCredentials(loginUser, user)) {
            return user;
        }

        return null;
    }

}