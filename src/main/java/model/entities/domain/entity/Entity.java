package model.entities.domain.entity;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.entitystatus.EntityStatus;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.enums.EntityClass;
import model.enums.Race;

public class Entity {

    private Long id;

    private String name;

    private AttackStats attackStats;

    private DefenseStats defenseStats;

    private MagicStats magicStats;

    private EntityClass entityClass;

    private Race race;

    private EntityStatus entityStatus;

    private double weight;



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

    public AttackStats getAttackStats() {
        return attackStats;
    }

    public void setAttackStats(AttackStats attackStats) {
        this.attackStats = attackStats;
    }

    public DefenseStats getDefenseStats() {
        return defenseStats;
    }

    public void setDefenseStats(DefenseStats defenseStats) {
        this.defenseStats = defenseStats;
    }

    public MagicStats getMagicStats() {
        return magicStats;
    }

    public void setMagicStats(MagicStats magicStats) {
        this.magicStats = magicStats;
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

    public EntityStatus getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(EntityStatus entityStatus) {
        this.entityStatus = entityStatus;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
