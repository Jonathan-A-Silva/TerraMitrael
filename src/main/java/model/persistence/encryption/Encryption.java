package model.persistence.encryption;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "encryption")
public class Encryption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encryption_id")
    private Long id;

    @Column(name = "seed", nullable = false)
    private final long seed;

    public Encryption() {
        this.seed = new Random().nextLong();
    }

    public Encryption(Long id) {
        this.id = id;
        this.seed = new Random().nextLong();
    }

    public Encryption(long seed) {
        this.seed = seed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSeed() {
        return seed;
    }

    public String encrypt(String text) {
        Random random = new Random(seed);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int shift = random.nextInt(65536);
            char newChar = (char) ((c + shift) % 65536);
            result.append(newChar);
        }
        return result.toString();
    }

    public String decrypt(String encryptedText) {
        Random random = new Random(seed);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            int shift = random.nextInt(65536);
            char originalChar = (char) ((c - shift + 65536) % 65536);
            result.append(originalChar);
        }
        return result.toString();
    }

}
