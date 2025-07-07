package model.entities.persistence.person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.entities.persistence.entity.PersistenceEntity;
import model.entities.persistence.user.User;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_first_name", nullable = false)
    private String first_name;

    @Column(name = "person_last_name", nullable = true)
    private String last_name;

    @Column(name = "person_family", nullable = true)
    private String family;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id", referencedColumnName = "entity_id")
    private PersistenceEntity entity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Person() {
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
