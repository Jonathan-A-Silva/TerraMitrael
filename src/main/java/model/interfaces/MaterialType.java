package model.interfaces;

import util.entities.MaterialUtilities;
import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;

public interface MaterialType {

    String getName();

    String getDescription();

    int getMaxQuantity();

    double getWeight();

    AttackStats getAttackStats();

    DefenseStats getDefenseStats();

    MagicStats getMagicStats();

    MaterialUtilities utilities();

    int getDurability();

    int getMaxDurability();

}
