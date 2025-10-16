package model.enums.armor;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ArmorType;

public enum Helmet implements ArmorType {

    VISOR_HELM(
            "Visor Helm",
            "A closed helmet with a visor, great protection but reduces perception.",
            new CombatStatus.Builder()
                    .attack(0.9, 0.9, 0.9, 0.9, 0.9)
                    .control(0.8, 0.7, 0.8)
                    .defense(1.6, 1.4, 1.0, 1.2)
                    .vitality(1.2, 1.0, 1.1, 0.9, 1.0)
                    .magic(0.9, 1.0, 1.0, 0.9, 0.8)
                    .build(),
            1.2
    ),

    OPEN_HELM(
            "Open Helm",
            "An open-faced helmet that balances defense and visibility.",
            new CombatStatus.Builder()
                    .attack(1.0, 1.0, 1.0, 1.0, 1.0)
                    .control(1.0, 1.0, 1.0)
                    .defense(1.2, 1.1, 1.0, 1.0)
                    .vitality(1.0, 1.0, 1.0, 1.0, 1.0)
                    .magic(1.0, 1.0, 1.0, 1.0, 1.0)
                    .build(),
            1.0
    ),

    HORNED_HELM(
            "Horned Helm",
            "A decorated helm with horns. Intimidates foes but is impractical.",
            new CombatStatus.Builder()
                    .attack(1.2, 0.9, 1.1, 1.1, 1.0)
                    .control(0.9, 0.8, 1.0)
                    .defense(1.3, 1.0, 0.9, 0.8)
                    .vitality(1.0, 1.0, 1.0, 0.9, 1.0)
                    .magic(0.9, 1.0, 1.0, 1.0, 1.0)
                    .build(),
            1.1
    ),

    MASK(
            "Mask",
            "A light mask that favors stealth over protection.",
            new CombatStatus.Builder()
                    .attack(1.1, 1.1, 1.2, 1.0, 1.0)
                    .control(1.2, 1.4, 1.1)
                    .defense(0.6, 0.8, 1.0, 0.8)
                    .vitality(0.9, 1.0, 1.0, 1.0, 1.0)
                    .magic(1.0, 1.0, 1.0, 1.0, 1.1)
                    .build(),
            0.7
    ),

    HOOD(
            "Hood",
            "A simple hood that offers minimal defense but boosts magic focus.",
            new CombatStatus.Builder()
                    .attack(0.8, 1.0, 0.9, 0.9, 1.0)
                    .control(1.0, 1.1, 1.0)
                    .defense(0.7, 0.8, 1.0, 0.9)
                    .vitality(1.0, 1.0, 1.0, 1.0, 1.0)
                    .magic(1.3, 1.1, 1.2, 1.0, 1.3)
                    .build(),
            0.8
    ),

    CROWN(
            "Crown",
            "A regal crown. Grants authority and charisma but no real defense.",
            new CombatStatus.Builder()
                    .attack(0.9, 1.0, 0.9, 1.0, 1.0)
                    .control(1.0, 1.0, 1.1)
                    .defense(0.5, 0.6, 0.8, 0.9)
                    .vitality(1.0, 1.0, 1.0, 1.0, 1.0)
                    .magic(1.4, 1.2, 1.3, 1.1, 1.2)
                    .build(),
            0.5
    ),

    CIRCLET(
            "Circlet",
            "A mystical circlet that enhances magical abilities.",
            new CombatStatus.Builder()
                    .attack(0.9, 1.0, 0.9, 1.0, 1.0)
                    .control(1.1, 1.0, 1.1)
                    .defense(0.6, 0.7, 1.0, 1.0)
                    .vitality(1.0, 1.0, 1.0, 1.0, 1.0)
                    .magic(1.6, 1.2, 1.3, 1.2, 1.4)
                    .build(),
            0.6
    ),

    PLAGUE_MASK(
            "Plague Doctor Mask",
            "Protects against poison and disease, but hinders peripheral vision.",
            new CombatStatus.Builder()
                    .attack(0.9, 0.9, 1.0, 1.0, 1.0)
                    .control(0.8, 0.7, 1.0)
                    .defense(1.0, 1.0, 1.1, 1.3)
                    .vitality(1.1, 1.0, 1.2, 1.0, 1.0)
                    .magic(1.2, 1.1, 1.1, 1.0, 1.1)
                    .build(),
            1.0
    ),

    ORACLE_HOOD(
            "Oracle Hood",
            "A ceremonial hood that enhances foresight and magical perception.",
            new CombatStatus.Builder()
                    .attack(0.8, 1.0, 0.9, 1.0, 1.0)
                    .control(1.2, 1.1, 1.3)
                    .defense(0.7, 0.8, 1.0, 0.9)
                    .vitality(1.0, 1.0, 1.0, 1.0, 1.0)
                    .magic(1.5, 1.2, 1.4, 1.1, 1.5)
                    .build(),
            0.7
    ),

    DRAGON_HELM(
            "Dragon Helm",
            "A legendary helm said to be made from dragon remains. Offers incredible resilience.",
            new CombatStatus.Builder()
                    .attack(1.2, 1.0, 1.1, 1.2, 1.0)
                    .control(1.0, 0.9, 1.1)
                    .defense(2.0, 1.6, 1.5, 1.4)
                    .vitality(1.5, 1.3, 1.5, 1.2, 1.2)
                    .magic(1.3, 1.1, 1.2, 1.1, 1.2)
                    .build(),
            2.0
    );


    private final String name;
    private final String description;
    private final CombatStatus combatStatus;
    private final double durability;

    Helmet(String name, String description, CombatStatus combatStatus, double durability) {
        this.name = name;
        this.description = description;
        this.combatStatus = combatStatus;
        this.durability = durability;
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

}
