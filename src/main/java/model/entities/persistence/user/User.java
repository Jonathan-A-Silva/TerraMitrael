package model.entities.persistence.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.entities.persistence.image.Image;
import model.entities.persistence.person.Person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "nickname", length = 32, nullable = false, unique = true)
    private String nickname;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Person> persons = new ArrayList<>();

    public User() {}

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public User(String nickname, String password, Image image) {
        this.nickname = nickname;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nickname, user.nickname) && Objects.equals(password, user.password) && Objects.equals(image, user.image) && Objects.equals(persons, user.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, password, image, persons);
    }

}
