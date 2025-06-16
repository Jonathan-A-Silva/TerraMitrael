package model.entities.persistence.person;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entities.persistence.entity.PersistenceEntity;
import model.entities.persistence.user.User;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", referencedColumnName = "id")
    private PersistenceEntity entity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_nickname")
    private User user;

    public Person() {
    }

    public Person(PersistenceEntity entity, User user) {
        this.entity = entity;
        this.user = user;
    }

    public Person(User user, PersistenceEntity entity, Long id) {
        this.user = user;
        this.entity = entity;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersistenceEntity getEntity() {
        return entity;
    }

    public void setEntity(PersistenceEntity entity) {
        this.entity = entity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
