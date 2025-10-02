package model.enums.armor;

import java.util.List;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;
import model.interfaces.Types.ArmorType;

public enum Helmet implements ArmorType {

    VISOR_HELM("Visor Helm", "A closed helmet with a visor, great protection but reduces perception.", new CombatStatus(1.3, 0.7, 0.6, 1.2, 0.8, 0.6, 0.0, -0.2, 0.0, 0, 0), 1.2, List.of(DamageType.SLASHING, DamageType.PIERCING)),
    OPEN_HELM("Open Helm", "An open-faced helmet that balances defense and visibility.", new CombatStatus(1.0, 1.0, 0.9, 1.0, 0.5, 0.5, 0.0, 0.0, 0.0, 0, 0), 1.0, List.of(DamageType.SLASHING)),
    HORNED_HELM("Horned Helm", "A decorated helm with horns. Intimidates foes but is impractical.", new CombatStatus(1.1, 0.9, 0.8, 1.1, 0.6, 0.5, 0.0, 0.0, 0.0, 0.1, 0), 1.1, List.of(DamageType.SLASHING, DamageType.BLUNT)),
    MASK("Mask", "A light mask that favors stealth over protection.", new CombatStatus(0.6, 1.4, 1.2, 0.8, 0.2, 0.3, 0.0, 0.0, 0.0, 0, 0), 0.7, List.of(DamageType.PIERCING)),
    HOOD("Hood", "A simple hood that offers minimal defense but boosts magic focus.", new CombatStatus(0.7, 1.0, 0.9, 0.7, 0.2, 0.2, 1.3, 1.1, 0.0, 0, 0), 0.8, List.of(DamageType.MAGICAL)),
    CROWN("Crown", "A regal crown. Grants authority and charisma but no real defense.", new CombatStatus(0.4, 1.0, 0.8, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5, 0.3, 0), 0.5, List.of()),
    CIRCLET("Circlet", "A mystical circlet that enhances magical abilities.", new CombatStatus(0.5, 1.1, 1.0, 0.6, 0.0, 0.0, 1.4, 1.2, 0.0, 0, 0), 0.6, List.of(DamageType.MAGICAL)),
    PLAGUE_MASK("Plague Doctor Mask", "Protects against poison and disease, but hinders peripheral vision.", new CombatStatus(0.9, 0.8, 0.8, 1.0, 0.3, 1.3, 0.0, -0.1, 0.0, 0, 0), 1.0, List.of(DamageType.POISON)),
    ORACLE_HOOD("Oracle Hood", "A ceremonial hood that enhances foresight and magical perception.", new CombatStatus(0.6, 1.0, 0.9, 0.7, 0.2, 0.2, 1.5, 1.4, 0.0, 0, 0), 0.7, List.of(DamageType.MAGICAL)),
    DRAGON_HELM("Dragon Helm", "A legendary helm said to be made from dragon remains. Offers incredible resilience.", new CombatStatus(1.8, 0.9, 1.0, 1.5, 1.5, 1.2, 0.5, 0.3, 0.0, 0, 0), 2.0, List.of(DamageType.FIRE, DamageType.SLASHING, DamageType.BLUNT));

    private final String name;
    private final String description;
    private final CombatStatus combatStatus;
    private final double durability;
    private final List<DamageType> defenseTypes;

    Helmet(String name, String description, CombatStatus combatStatus, double durability, List<DamageType> damageTypes) {
        this.name = name;
        this.description = description;
        this.combatStatus = combatStatus;
        this.durability = durability;
        this.defenseTypes = damageTypes;
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
    public List<DamageType> getDefenseTypes() {
        return defenseTypes;
    }

}
