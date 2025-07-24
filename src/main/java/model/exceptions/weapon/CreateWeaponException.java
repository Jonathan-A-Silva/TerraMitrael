package model.exceptions.weapon;

public class CreateWeaponException extends RuntimeException {

    public CreateWeaponException() {
    }

    public CreateWeaponException(String message) {
        super(message);
    }

}
