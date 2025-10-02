package model.domain.items;

import java.util.List;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;
import model.interfaces.Types.MaterialType;
import model.interfaces.Types.WeaponType;

public class Weapon extends Item {

    private final CombatStatus combatStatus;
    private final List<DamageType> damageType;
    private final int durability;
    private final int max_durability;

    public Weapon(WeaponType weaponType, Material... materials) {
        super(weaponType.getName(), weaponType.getDescription(), 1, 1, mergeWeight(materials));
        this.combatStatus = mergeCombatStatus(weaponType, materials);
        this.damageType = weaponType.getDamageTypes();
        this.durability = mergeDurability(weaponType, materials);
        this.max_durability = mergeDurability(weaponType, materials);
    }

    public CombatStatus getCombatStatus() {
        return combatStatus;
    }

    public List<DamageType> getDamageType() {
        return damageType;
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
