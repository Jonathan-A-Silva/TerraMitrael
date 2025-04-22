package model.enums;

import java.util.List;

public enum SwordType {

    LONGSWORD(7, 0.6, 12, 1.5, 200, List.of(DamageType.SLASHING)),
    SHORTSWORD(4, 2.1, 7, 1.2, 150, List.of(DamageType.SLASHING)),
    GREATSWORD(10, 0.4, 10, 2.0, 250, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    KATANA(6, 1.4, 20, 1.8, 180, List.of(DamageType.SLASHING)),
    SCIMITAR(5, 1.6, 10, 1.4, 170, List.of(DamageType.SLASHING)),
    CLAYMORE(9, 0.5, 8, 1.6, 230, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    RAPIER(3, 2.4, 25, 1.3, 130, List.of(DamageType.PIERCING)),
    FALCHION(6, 1.0, 15, 1.6, 190, List.of(DamageType.SLASHING));

    private final double attack_damage;
    private final double attack_speed;
    private final double critical_chance;
    private final double critical_damage;
    private final double durability;
    private final List<DamageType> damageTypes;

    SwordType(double attack_damage, double attack_speed, double critical_chance, double critical_damage, double durability, List<DamageType> damageTypes) {
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.critical_chance = critical_chance;
        this.critical_damage = critical_damage;
        this.durability = durability;
        this.damageTypes = damageTypes;
    }

    public double getAttackDamage() {
        return attack_damage;
    }

    public double getAttackSpeed() {
        return attack_speed;
    }

    public double getCriticalChance() {
        return critical_chance;
    }

    public double getCriticalDamage() {
        return critical_damage;
    }

    public double getDurability() {
        return durability;
    }

    public List<DamageType> getDamageTypes() {
        return damageTypes;
    }

}
