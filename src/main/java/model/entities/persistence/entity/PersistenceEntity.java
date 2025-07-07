package model.entities.persistence.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import model.enums.EntityClass;
import model.enums.Race;
import model.enums.Status;

@Entity
@Table(name = "persistence_entity")
public class PersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Long id;

    @Column(name = "entity_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private EntityClass entityClass;

    @Enumerated(EnumType.STRING)
    private Race race;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "entity_status", joinColumns = @JoinColumn(name = "entity_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "status_key")
    @Column(name = "status_value")
    private Map<Status, Integer> status = new HashMap<>();

    public PersistenceEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityClass getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(EntityClass entityClass) {
        this.entityClass = entityClass;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Map<Status, Integer> getStatus() {
        return status;
    }

    public void setStatus(Map<Status, Integer> status) {
        this.status = status;
    }
}
