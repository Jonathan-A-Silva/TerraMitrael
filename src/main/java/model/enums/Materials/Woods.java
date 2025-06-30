package model.enums.Materials;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.enums.MaterialRole;
import model.interfaces.MaterialType;
import util.MaterialUtilities;

public enum Woods implements MaterialType {

    Pine(
            "pine",
            "That's a simple material.",
            16,
            20,
            1,
            new AttackStats(0.1, 0.1, 0, 0),
            null,
            null,
            new MaterialUtilities(MaterialRole.BLADE, MaterialRole.GUARD, MaterialRole.HANDLE)
    );


    private final String name;
    private final String description;
    private final int max_quantity;
    private final int durability;
    private final double weight;
    private final AttackStats attackStats;
    private final DefenseStats defenseStats;
    private final MagicStats magicStats;
    private final MaterialUtilities materialUtilities;
    Woods(String name, String description, int max_quantity, int durability, double weight, AttackStats attackStats, DefenseStats defenseStats, MagicStats magicStats, MaterialUtilities materialUtilities) {
        this.name = name;
        this.description = description;
        this.max_quantity = max_quantity;
        this.durability = durability;
        this.weight = weight;
        this.attackStats = attackStats;
        this.defenseStats = defenseStats;
        this.magicStats = magicStats;
        this.materialUtilities = materialUtilities;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public int getMaxQuantity() {
        return max_quantity;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public AttackStats getAttackStats() {
        return attackStats;
    }

    @Override
    public DefenseStats getDefenseStats() {
        return defenseStats;
    }

    @Override
    public MagicStats getMagicStats() {
        return magicStats;
    }

    @Override
    public MaterialUtilities utilities() {
        return materialUtilities;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public int getMaxDurability() {
        return durability;
    }


}