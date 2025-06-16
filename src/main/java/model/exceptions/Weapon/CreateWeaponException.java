package model.exceptions.Weapon;

public class CreateWeaponException extends RuntimeException {

    public CreateWeaponException() {
    }

    public CreateWeaponException(String message) {
        super(message);
    }

}
