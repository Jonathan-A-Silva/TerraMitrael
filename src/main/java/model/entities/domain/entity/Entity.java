package model.entities.domain.entity;

import java.util.EnumMap;
import java.util.Map;

import model.enums.Class;
import model.enums.Status;

public class Entity {

    private Long id;
    private String name;
    private float life;
    private float stamina;
    private float mana;
    private Class entityClass;
    private Map<Status, Float> statusMap;

    public Entity() {
        statusMap = new EnumMap<>(Status.class);
    }

    public Entity(String name, float life, float stamina, float mana, Class entityClass, Map<Status, Float> statusMap) {
        this.name = name;
        this.life = life;
        this.stamina = stamina;
        this.mana = mana;
        this.entityClass = entityClass;
        this.statusMap = statusMap;
    }

    public Entity(long id, String name, float life, float stamina, float mana, Class entityClass, Map<Status, Float> statusMap) {
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
