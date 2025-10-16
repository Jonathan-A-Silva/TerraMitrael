package model.domain.items;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ArmorType;

public class Armor extends Item{

    private final CombatStatus combatStatus;
    private final int durability;
    private final int max_durability;

    public Armor(ArmorType armorType, Material... materials) {
        super(armorType.getName(), armorType.getDescription(), 1, 1, mergeWeight(materials));
        this.combatStatus = mergeCombatStatus(armorType, materials);
        this.durability = mergeDurability(armorType, materials);
        this.max_durability = mergeDurability(armorType, materials);
    }

    public CombatStatus getCombatStatus() {
        return combatStatus;
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

    private CombatStatus mergeCombatStatus(ArmorType armorType, Material... materials) {
        CombatStatus combatStatus = new CombatStatus();

        for (Material material : materials) {
            combatStatus.mergeStatus(material.getCombatStatus());
        }

        combatStatus.multiplierStatus(armorType.getCombatStatus());

        return combatStatus;
    }

    private int mergeDurability(ArmorType armorType, Material... materials) {
        int totalDurability = 0;

        for (Material material : materials) {
            totalDurability += (int) material.getWeight();
        }

        return (int) (armorType.getDurability() * (totalDurability * 100));
    }

}
