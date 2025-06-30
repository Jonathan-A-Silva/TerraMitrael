package model.entities.persistence.encryption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {

    Encryption encryption = new Encryption(5829233280470091053L);

    @Test
    void encrypt() {
        String password = "123";
        System.out.println("encrypt: " + encryption.encrypt(password));
    }

    @Test
    void decrypt() {
        String password = "b=B";
        System.out.println("decrypt: " + encryption.decrypt(password));
    }
}