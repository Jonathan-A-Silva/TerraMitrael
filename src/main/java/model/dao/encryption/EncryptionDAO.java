package model.dao.encryption;

import model.entities.persistence.encryption.Encryption;

public interface EncryptionDAO {
    void saveEncryption(Encryption encryption);

    void deleteEncryption(Encryption encryption);

    void updateEncryption(Encryption encryption);

    Encryption getEncryptionByUserId(Long userId);
}