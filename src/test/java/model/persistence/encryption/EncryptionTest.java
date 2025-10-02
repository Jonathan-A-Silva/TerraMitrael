package model.persistence.encryption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptionTest {

    @Test
    void testEncryptDecryptMultipleTimes() {
        String original = "";

        int value = 1;
        long lastTime = System.currentTimeMillis();

        for (int i = 0; i < value; i++) {
            Encryption encryption = new Encryption();

            String encryptionText = encryption.encrypt(original);
            String decryptText = encryption.decrypt(encryptionText);

            assertEquals(original, decryptText);

            System.out.println(encryptionText);
            System.out.println(decryptText);

            long now = System.currentTimeMillis();
            if (now - lastTime >= 1000) {
                double progress = ((double) (i + 1) / value) * 100;
                System.out.printf("Progresso: %.3f%%\n", progress);
                lastTime = now;
            }
        }

    }

}