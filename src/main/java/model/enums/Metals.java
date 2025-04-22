package model.enums;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.interfaces.MaterialType;

public enum Metals implements MaterialType {

    COPPER(
            new AttackStats(0.5, 0.7, 7, 1),
            new DefenseStats(1, 1, 0.2),
            null,
            true,
            true,
            false,
            60
    ),
    IRON(
            new AttackStats(1.0, 1.0, 10, 2),
            new DefenseStats(2, 1.5, 0.5),
            null,
            true,
            true,
            true
            140,
    ),
    STEEL(
            new AttackStats(1.5, 1.2, 15, 3),
            new DefenseStats(3, 2, 0.7),
            null,
            true,
            true,
            true,
            320
    );

    private final AttackStats attackStats;
    private final DefenseStats defenseStats;
    private final MagicStats magicStats;
    private final boolean canBeBlade;
    private final boolean canBeGuard;
    private final boolean canBeHandle;
    private final double durability;

    Metals(AttackStats attackStats, DefenseStats defenseStats, MagicStats magicStats, boolean canBeBlade, boolean canBeGuard, boolean canBeHandle, double durability) {
        this.attackStats = attackStats;
        this.defenseStats = defenseStats;
        this.magicStats = magicStats;
        this.canBeBlade = canBeBlade;
        this.canBeGuard = canBeGuard;
        this.canBeHandle = canBeHandle;
        this.durability = durability;
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
    public boolean canBeBlade() {
        return canBeBlade;
    }

    @Override
    public boolean canBeGuard() {
        return canBeGuard;
    }

    @Override
    public boolean canBeHandle() {
        return canBeHandle;
    }

    public double getDurability() {
        return durability;
    }

}
