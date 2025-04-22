package model.entities.domain.weapon;

import java.util.List;

import model.entities.domain.item.Item;
import model.enums.DamageType;

public abstract class Weapon extends Item {

    private double attack_damage;
    private double attack_speed;
    private double critical_chance;
    private double critical_damage;
    private double durability;
    private List<DamageType> damageType;

    public Weapon(String nome, String description, double attack_damage, double attack_speed, double critical_chance, double critical_damage, double durability, List<DamageType> damageType) {
        super(nome, description);
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.critical_chance = critical_chance;
        this.critical_damage = critical_damage;
        this.durability = durability;
        this.damageType = damageType;
    }

    public double getAttack_damage() {
        return attack_damage;
    }

    public void setAttack_damage(double attack_damage) {
        this.attack_damage = attack_damage;
    }

    public double getAttack_speed() {
        return attack_speed;
    }

    public void setAttack_speed(double attack_speed) {
        this.attack_speed = attack_speed;
    }

    public double getCritical_chance() {
        return critical_chance;
    }

    public void setCritical_chance(double critical_chance) {
        this.critical_chance = critical_chance;
    }

    public double getCritical_damage() {
        return critical_damage;
    }

    public void setCritical_damage(double critical_damage) {
        this.critical_damage = critical_damage;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public List<DamageType> getDamageType() {
        return damageType;
    }

    public void setDamageType(List<DamageType> damageType) {
        this.damageType = damageType;
    }

}
