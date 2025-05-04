package model.enums.Materials;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.interfaces.MaterialType;

public enum Woods implements MaterialType {

    Pine(
            "Pine",
            "test",
            new AttackStats(0.0, 0.2, 0, 0),
            null,
            null,
            true,
            true,
            true,
            10
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

    Woods(String name, String description1, AttackStats attackStats, DefenseStats defenseStats, MagicStats magicStats,
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