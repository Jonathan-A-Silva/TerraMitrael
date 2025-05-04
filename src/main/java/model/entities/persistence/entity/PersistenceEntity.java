package model.entities.persistence.entity;

import java.util.EnumMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import model.enums.Class;
import model.enums.Status;

@Entity
@Table(name = "persistence_entity") // Se quiser nomear explicitamente
public class PersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "life", nullable = false)
    private float life;

    @Column(name = "stamina", nullable = false)
    private float stamina;

    @Column(name = "mana", nullable = false)
    private float mana;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_id")
    private Class entityClass;

    @ElementCollection
    @CollectionTable(name = "entidade_status", joinColumns = @JoinColumn(name = "entidade_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "valor")
    private Map<Status, Float> statusMap = new EnumMap<>(Status.class);

    public PersistenceEntity() {
    }

    public PersistenceEntity(Long id, String name, float life, float stamina, float mana, Class entityClass, Map<Status, Float> statusMap) {
        this.id = id;
        this.name = name;
        this.life = life;
        this.stamina = stamina;
        this.mana = mana;
        this.entityClass = entityClass;
        this.statusMap = statusMap;
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

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public Map<Status, Float> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<Status, Float> statusMap) {
        this.statusMap = statusMap;
    }

}
