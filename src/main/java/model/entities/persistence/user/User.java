package model.entities.persistence.user;

import java.util.List;

import model.entities.persistence.image.Image;
import model.entities.persistence.person.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "nickname", length = 32, nullable = false, unique = true)
    private String nickname;

    @Column(name = "password", length = 32, nullable = false, unique = false)
    private String password;

    @Column(name = "seed")
    private long seed;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    private List<Person> persons;

    public User() {
    }

    public User(String nickname, String password, long seed, Image image) {
        this.nickname = nickname;
        this.password = password;
        this.seed = seed;
        this.image = image;
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

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
