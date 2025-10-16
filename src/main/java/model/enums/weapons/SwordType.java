package model.enums.weapons;

import java.util.Map;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;
import model.interfaces.Types.WeaponType;

public enum SwordType implements WeaponType {

    LONGSWORD(
            "Longsword",
            "A versatile blade with balanced attributes.",
            new CombatStatus.Builder()
                    .attack(1.0, 1.0, 1.0, 1.0, 1.0)
                    .build(),
            1.0,
            Map.of(
                    0.8f, DamageType.SLASHING,
                    0.2f, DamageType.BLUNT
            )
    ),

    SHORTSWORD(
            "Shortsword",
            "A quick and light weapon ideal for fast strikes.",
            new CombatStatus.Builder()
                    .attack(0.8, 1.6, 0.9, 0.8, 0.9)
                    .build(),
            0.8,
            Map.of(
                    0.9f, DamageType.SLASHING,
                    0.1f, DamageType.PIERCING
            )
    ),

    GREATSWORD(
            "Greatsword",
            "A massive sword that deals heavy damage but is slow.",
            new CombatStatus.Builder()
                    .attack(1.6, 0.6, 0.8, 1.3, 1.2)
                    .build(),
            1.4,
            Map.of(
                    0.65f, DamageType.SLASHING,
                    0.35f, DamageType.BLUNT
            )
    ),

    KATANA(
            "Katana",
            "A sharp, precise blade known for high critical potential.",
            new CombatStatus.Builder()
                    .attack(1.0, 1.3, 1.4, 1.3, 1.0)
                    .build(),
            0.9,
            Map.of(
                    0.95f, DamageType.SLASHING,
                    0.05f, DamageType.PIERCING
            )
    ),

    SCIMITAR(
            "Scimitar",
            "A curved sword designed for quick, sweeping attacks.",
            new CombatStatus.Builder()
                    .attack(0.9, 1.5, 1.1, 1.0, 0.9)
                    .build(),
            0.85,
            Map.of(
                    1.0f, DamageType.SLASHING
            )
    ),

    CLAYMORE(
            "Claymore",
            "A heavy two-handed sword that crushes armor.",
            new CombatStatus.Builder()
                    .attack(1.4, 0.7, 0.8, 1.2, 1.3)
                    .build(),
            1.3,
            Map.of(
                    0.6f, DamageType.SLASHING,
                    0.4f, DamageType.BLUNT
            )
    ),

    RAPIER(
            "Rapier",
            "A thin, agile weapon focused on speed and critical hits.",
            new CombatStatus.Builder()
                    .attack(0.7, 1.8, 1.6, 0.9, 0.8)
                    .build(),
            0.7,
            Map.of(
                    0.9f, DamageType.PIERCING,
                    0.1f, DamageType.SLASHING
            )
    ),

    FASHION(
            "Fashion",
            "A slightly curved blade offering a good balance of speed and power.",
            new CombatStatus.Builder()
                    .attack(1.1, 1.1, 1.2, 1.1, 1.0)
                    .build(),
            1.0,
            Map.of(
                    0.85f, DamageType.SLASHING,
                    0.15f, DamageType.BLUNT
            )
    );


    private final String name;
    private final String description;
    private final CombatStatus combatStatus;
    private final double durability;
    private final Map<Float, DamageType> damageTypes;

    SwordType(String name, String description, CombatStatus combatStatus, double durability, Map<Float, DamageType> damageTypes) {
        this.name = name;
        this.description = description;
        this.combatStatus = combatStatus;
        this.durability = durability;
        this.damageTypes = damageTypes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public CombatStatus getCombatStatus() {
        return combatStatus;
    }

    @Override
    public double getDurability() {
        return durability;
    }

    @Override
    public Map<Float, DamageType> getDamageTypes() {
        return damageTypes;
    }
}
