package model.interfaces;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;

public interface MaterialType {

    AttackStats getAttackStats();

    DefenseStats getDefenseStats();

    MagicStats getMagicStats();

    boolean canBeBlade();

    boolean canBeGuard();

    boolean canBeHandle();
}