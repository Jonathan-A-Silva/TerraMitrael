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
@Table(name = "persistence_entity")
public class PersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

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
    @Column(name = "class_id")
    private Class entityClass;

    @ElementCollection
    @CollectionTable(name = "entidade_status", joinColumns = @JoinColumn(name = "entidade_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "valor")
    private Map<Status, Float> statusMap = new EnumMap<>(Status.class);

    public PersistenceEntity() {
    }

    public PersistenceEntity(String name, float max_life, float life, float max_stamina, float stamina, float max_mana, float mana, Class entityClass, Map<Status, Float> statusMap) {
        this.name = name;
        this.max_life = max_life;
        this.life = life;
        this.max_stamina = max_stamina;
        this.stamina = stamina;
        this.max_mana = max_mana;
        this.mana = mana;
        this.entityClass = entityClass;
        this.statusMap = statusMap;
    }

    public PersistenceEntity(Long id, String name, float max_life, float life, float max_stamina, float stamina, float max_mana, float mana, Class entityClass, Map<Status, Float> statusMap) {
        this.id = id;
        this.name = name;
        this.max_life = max_life;
        this.life = life;
        this.max_stamina = max_stamina;
        this.stamina = stamina;
        this.max_mana = max_mana;
        this.mana = mana;
        this.entityClass = entityClass;
        this.statusMap = statusMap;
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

    public float getMax_life() {
        return max_life;
    }

    public void setMax_life(float max_life) {
        this.max_life = max_life;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getMax_stamina() {
        return max_stamina;
    }

    public void setMax_stamina(float max_stamina) {
        this.max_stamina = max_stamina;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public float getMax_mana() {
        return max_mana;
    }

    public void setMax_mana(float max_mana) {
        this.max_mana = max_mana;
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
