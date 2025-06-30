package model.enums;

import java.util.List;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.interfaces.WeaponType;

public enum SwordType implements WeaponType {

    LONGSWORD("Longsword", "A versatile blade with balanced attributes.", new AttackStats(1.0, 1.0, 1.0, 1.0), 1.0, List.of(DamageType.SLASHING)),
    SHORTSWORD("Shortsword", "A quick and light weapon ideal for fast strikes.", new AttackStats(0.7, 1.6, 0.8, 0.9), 0.8, List.of(DamageType.SLASHING)),
    GREATSWORD("Greatsword", "A massive sword that deals heavy damage but is slow.", new AttackStats(1.5, 0.6, 0.7, 1.3), 1.4, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    KATANA("Katana", "A sharp, precise blade known for high critical potential.", new AttackStats(0.9, 1.3, 1.4, 1.2), 0.9, List.of(DamageType.SLASHING)),
    SCIMITAR("Scimitar", "A curved sword designed for quick, sweeping attacks.", new AttackStats(0.85, 1.4, 1.1, 1.0), 0.85, List.of(DamageType.SLASHING)),
    CLAYMORE("Claymore", "A heavy two-handed sword that crushes armor.", new AttackStats(1.3, 0.7, 0.75, 1.2), 1.3, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    RAPIER("Rapier", "A thin, agile weapon focused on speed and critical hits.", new AttackStats(0.6, 1.8, 1.6, 0.9), 0.7, List.of(DamageType.PIERCING)),
    FALCHION("Falchion", "A slightly curved blade offering a good balance of speed and power.", new AttackStats(1.1, 1.0, 1.2, 1.1), 1.0, List.of(DamageType.SLASHING));

    private final String name;
    private final String description;
    private final AttackStats attackStats;
    private final double durability;
    private final List<DamageType> damageTypes;

    SwordType(String name, String description, AttackStats attackStats, double durability_multiplier, List<DamageType> damageTypes) {
        this.name = name;
        this.description = description;
        this.attackStats = attackStats;
        this.durability = durability_multiplier;
        this.damageTypes = damageTypes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AttackStats getAttackStats() {
        return attackStats;
    }

    @Override
    public DefenseStats getDefenseStats() {
        return null;
    }

    @Override
    public MagicStats getMagicStats() {
        return null;
    }

    @Override
    public double getDurability() {
        return durability;
    }

    public List<DamageType> getDamageTypes() {
        return damageTypes;
    }

}
