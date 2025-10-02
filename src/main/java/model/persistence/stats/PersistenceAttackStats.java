package model.persistence.stats;

import javax.persistence.*;

@Entity
@Table(name = "attack_stats")
public class PersistenceAttackStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "damage")
    private Double damage;

    @Column(name = "speed")
    private Double speed;

    @Column(name = "critical_chance")
    private Double criticalChance;

    @Column(name = "critical_damage")
    private Double criticalDamage;

    public PersistenceAttackStats() {}

    public PersistenceAttackStats(Double damage, Double speed, Double criticalChance, Double criticalDamage) {
        this.damage = damage;
        this.speed = speed;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(Double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public Double getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(Double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

}
