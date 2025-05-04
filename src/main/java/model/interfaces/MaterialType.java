package model.interfaces;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;

public interface MaterialType {

    String getName();

    String getDescription();

    AttackStats getAttackStats();

    DefenseStats getDefenseStats();

    MagicStats getMagicStats();

    boolean likeBlade();

    boolean likeGuard();

    boolean likeHandle();

    int getDurability();

}
