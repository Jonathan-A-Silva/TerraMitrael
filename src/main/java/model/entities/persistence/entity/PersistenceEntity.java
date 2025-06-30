package model.entities.persistence.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.enums.Class;
import model.enums.Race;
import model.enums.Status;
import util.StatusMapConverter;

@Entity
@Table(name = "persistence_entity")
public class PersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "attack", nullable = false)
    private float attack;

    @Column(name = "defense", nullable = false)
    private float defense;

    @Column(name = "critical_chance", nullable = false)
    private float critical_chance;

    @Column(name = "critical_damage", nullable = false)
    private float critical_damage;

    @Column(name = "max_life", nullable = false)
    private float max_life;

    @Column(name = "life", nullable = false)
    private float life;

    @Column(name = "max_stamina", nullable = false)
    private float max_stamina;

    @Column(name = "stamina", nullable = false)
    private float stamina;

    @Column(name = "max_mana", nullable = false)
    private float max_mana;

    @Column(name = "mana", nullable = false)
    private float mana;

    @Enumerated(EnumType.STRING)
    @Column(name = "class")
    private Class entityClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "Race")
    private Race race;

    @Column(name = "status", columnDefinition = "JSON")
    @Convert(converter = StatusMapConverter.class)
    private Map<Status, Float> status = new HashMap<>();


}
