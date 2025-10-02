package model.persistence.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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


}
