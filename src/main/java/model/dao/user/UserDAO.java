package model.dao.user;

import model.entities.persistence.user.User;

public interface UserDAO {

    void saveUser(User usuario);

    void deleteUser(User usuario);

    void updateUser(User usuario);

    User getUserForId(Long id);

    User getUserForNickname(String nickname);

    User getUserForEmail(String email);

}
