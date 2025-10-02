package model.domain.items;

import java.util.List;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;
import model.interfaces.Types.ArmorType;
import model.interfaces.Types.MaterialType;
import model.interfaces.Types.WeaponType;

public class Armor extends Item{

    private final CombatStatus combatStatus;
    private final List<DamageType> defenseTypes;
    private final int durability;
    private final int max_durability;

    public Armor(ArmorType armorType, Material... materials) {
        super(armorType.getName(), armorType.getDescription(), 1, 1, mergeWeight(materials));
        this.combatStatus = mergeCombatStatus(armorType, materials);
        this.defenseTypes = armorType.getDamageTypes();
        this.durability = mergeDurability(armorType, materials);
        this.max_durability = mergeDurability(armorType, materials);
    }

    public CombatStatus getCombatStatus() {
        return combatStatus;
    }

    public List<DamageType> getDefenseTypes() {
        return defenseTypes;
    }

    public int getDurability() {
        return durability;
    }

    public int getMax_durability() {
        return max_durability;
    }

    private static double mergeWeight(Material... materials) {
        double weight = 0.0;

        for (Material material : materials) {
            weight += material.getWeight();
        }

        return weight;
    }

    private CombatStatus mergeCombatStatus(WeaponType weaponType, Material... materials) {
        CombatStatus combatStatus = new CombatStatus();

        for (MaterialType material : materials) {
            combatStatus.mergeStatus(material.getCombatStatus());
        }

        combatStatus.multiplierStatus(weaponType.getCombatStatus());

        return combatStatus;
    }

    private int mergeDurability(WeaponType weaponType, Material... materials) {
        int totalDurability = 0;

        for (Material material : materials) {
            totalDurability += (int) material.getWeight();
        }

        return (int) (weaponType.getDurability() * (totalDurability * 100));
    }

}
