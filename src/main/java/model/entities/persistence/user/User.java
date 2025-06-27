package model.entities.persistence.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entities.persistence.encryption.Encryption;
import model.entities.persistence.image.Image;
import model.entities.persistence.person.Person;
import model.enums.Materials.Presence;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "email", length = 256, nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", length = 32, nullable = false, unique = true)
    private String nickname;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Person> persons = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "encryption_id", nullable = false, referencedColumnName = "encryption_id")
    private Encryption encryption;

    @Enumerated(EnumType.STRING)
    @Column(name = "presence", nullable = false)
    private Presence presence;

    public User() {
    }

    public User(String nickname, String password, Encryption encryption) {
        this.nickname = nickname;
        this.password = encryption.encrypt(password);
        this.encryption = encryption;
        this.presence = Presence.OFFLINE;
    }

    public User(String nickname, String password, Image image, Encryption encryption) {
        this.nickname = nickname;
        this.password = encryption.encrypt(password);
        this.image = image;
        this.encryption = encryption;
        this.presence = Presence.OFFLINE;
    }

    public User(String email, String nickname, String password, Encryption encryption) {
        this.email = email;
        this.nickname = nickname;
        this.password = encryption.encrypt(password);
        this.encryption = encryption;
        this.presence = Presence.OFFLINE;
    }

    public User(long id, String nickname, String password, Encryption encryption) {
        this.id = id;
        this.nickname = nickname;
        this.password = encryption.encrypt(password);
        this.encryption = encryption;
        this.presence = Presence.OFFLINE;
    }

    public User(long id, String email, String nickname, String password, Encryption encryption) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = encryption.encrypt(password);
        this.encryption = encryption;
        this.presence = Presence.OFFLINE;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Encryption getEncryption() {
        return encryption;
    }

    public void setEncryption(Encryption encryption) {
        this.encryption = encryption;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public boolean credentialsEquals(User other) {
        if (this == other) return true;
        if (other == null) return false;

        return Objects.equals(this.nickname, other.nickname) && Objects.equals(this.password, other.password);
    }

}
