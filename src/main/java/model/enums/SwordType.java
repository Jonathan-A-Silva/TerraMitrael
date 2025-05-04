package model.enums;

import java.util.List;

public enum SwordType {

    LONGSWORD("Longsword", "A versatile blade with balanced attributes.", 1.0, 1.0, 1.0, 1.0, 1.0, List.of(DamageType.SLASHING)),
    SHORTSWORD("Shortsword", "A quick and light weapon ideal for fast strikes.", 0.7, 1.6, 0.8, 0.9, 0.8, List.of(DamageType.SLASHING)),
    GREATSWORD("Greatsword", "A massive sword that deals heavy damage but is slow.", 1.5, 0.6, 0.7, 1.3, 1.4, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    KATANA("Katana", "A sharp, precise blade known for high critical potential.", 0.9, 1.3, 1.4, 1.2, 0.9, List.of(DamageType.SLASHING)),
    SCIMITAR("Scimitar", "A curved sword designed for quick, sweeping attacks.", 0.85, 1.4, 1.1, 1.0, 0.85, List.of(DamageType.SLASHING)),
    CLAYMORE("Claymore", "A heavy two-handed sword that crushes armor.", 1.3, 0.7, 0.75, 1.2, 1.3, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    RAPIER("Rapier", "A thin, agile weapon focused on speed and critical hits.", 0.6, 1.8, 1.6, 0.9, 0.7, List.of(DamageType.PIERCING)),
    FALCHION("Falchion", "A slightly curved blade offering a good balance of speed and power.", 1.1, 1.0, 1.2, 1.1, 1.0, List.of(DamageType.SLASHING));

    private final String name;
    private final String description;
    private final double attack_damage_multiplier;
    private final double attack_speed_multiplier;
    private final double critical_chance_multiplier;
    private final double critical_damage_multiplier;
    private final double durability_multiplier;
    private final List<DamageType> damageTypes;

    SwordType(String name, String description, double attack_damage_multiplier, double attack_speed_multiplier, double critical_chance_multiplier, double critical_damage_multiplier, double durability_multiplier, List<DamageType> damageTypes) {
        this.name = name;
        this.description = description;
        this.attack_damage_multiplier = attack_damage_multiplier;
        this.attack_speed_multiplier = attack_speed_multiplier;
        this.critical_chance_multiplier = critical_chance_multiplier;
        this.critical_damage_multiplier = critical_damage_multiplier;
        this.durability_multiplier = durability_multiplier;
        this.damageTypes = damageTypes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getAttack_damage_multiplier() {
        return attack_damage_multiplier;
    }

    public double getAttack_speed_multiplier() {
        return attack_speed_multiplier;
    }

    public double getCritical_chance_multiplier() {
        return critical_chance_multiplier;
    }

    public double getCritical_damage_multiplier() {
        return critical_damage_multiplier;
    }

    public double getDurability_multiplier() {
        return durability_multiplier;
    }

    public List<DamageType> getDamageTypes() {
        return damageTypes;
    }

}
