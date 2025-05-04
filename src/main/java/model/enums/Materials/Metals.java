package model.enums.Materials;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.interfaces.MaterialType;

public enum Metals implements MaterialType {

    COPPER(
            "Copper",
            "test",
            new AttackStats(0.5, 0.7, 7, 1),
            new DefenseStats(1, 1, 0.2),
            null,
            true,
            true,
            false,
            60
    ),
    IRON(
            "Iron",
            "test",
            new AttackStats(1.0, 1.0, 10, 2),
            new DefenseStats(2, 1.5, 0.5),
            null,
            true,
            true,
            false,
            140
    ),
    STEEL(
            "Steel",
            "test",
            new AttackStats(1.5, 1.2, 15, 3),
            new DefenseStats(3, 2, 0.7),
            null,
            true,
            true,
            false,
            320
    );

    private final String name;
    private final String description;
    private final AttackStats attackStats;
    private final DefenseStats defenseStats;
    private final MagicStats magicStats;
    private final boolean canBeBlade;
    private final boolean canBeGuard;
    private final boolean canBeHandle;
    private final int durability;

    Metals(String name, String description1, AttackStats attackStats, DefenseStats defenseStats, MagicStats magicStats,
           boolean canBeBlade, boolean canBeGuard, boolean canBeHandle, int durability) {
        this.name = name;
        this.description = description1;
        this.attackStats = attackStats;
        this.defenseStats = defenseStats;
        this.magicStats = magicStats;
        this.canBeBlade = canBeBlade;
        this.canBeGuard = canBeGuard;
        this.canBeHandle = canBeHandle;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
    public boolean likeBlade() {
        return canBeBlade;
    }

    @Override
    public boolean likeGuard() {
        return canBeGuard;
    }

    @Override
    public boolean likeHandle() {
        return canBeHandle;
    }

    public int getDurability() {
        return durability;
    }

}
