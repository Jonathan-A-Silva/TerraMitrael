package util.web;

import model.persistence.user.User;
import model.enums.EntityClass;
import model.enums.Race;
import model.exceptions.person.InvalidPersonException;
import model.exceptions.user.InvalidUserException;

public class Validator {

    public static void validateLoginCredentials(String emailOrNickname, String password) throws InvalidUserException {
        if (emailOrNickname == null || emailOrNickname.trim().isEmpty()) {
            throw new InvalidUserException("Email ou nickname é obrigatório.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidUserException("Senha é obrigatória.");
        }
    }

    public static void validateRegistration(User user) throws InvalidUserException {
        if (user.getNickname() == null || user.getNickname().trim().isEmpty()) {
            throw new InvalidUserException("Nickname é obrigatório.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new InvalidUserException("A senha deve ter pelo menos 6 caracteres.");
        }
        if (user.getEmail() == null || !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidUserException("Email inválido.");
        }
    }

    public static void validateProfileEdit(String email, String nickname, String password) throws InvalidUserException {
        if (email != null && !email.isBlank() && !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidUserException("Email inválido.");
        }
        if (nickname != null && nickname.trim().isEmpty()) {
            throw new InvalidUserException("Nickname não pode ser vazio.");
        }
        if (password != null && !password.isBlank() && password.length() < 6) {
            throw new InvalidUserException("A senha deve ter pelo menos 6 caracteres.");
        }
    }

    public static boolean validateCredentials(User sessionUser, User dbUser) {
        return sessionUser != null && dbUser != null && sessionUser.credentialsEquals(dbUser);
    }

    public static void validatePersonRegistration(String first_name, EntityClass entityClass, Race race) throws InvalidPersonException {
        if (first_name != null && first_name.isBlank()) {
            throw new InvalidPersonException("Nome não pode ser vazio.");
        }
        if (entityClass != null) {
            try {
                EntityClass.valueOf(entityClass.name());
            } catch (IllegalArgumentException e) {
                throw new InvalidPersonException("Classe inválida: " + entityClass);
            }
        }
        if (race != null) {
            try {
                Race.valueOf(race.name());
            } catch (IllegalArgumentException e) {
                throw new InvalidPersonException("Raça inválida: " + race);
            }
        }
    }

}
