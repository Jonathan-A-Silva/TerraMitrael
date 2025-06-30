package model.interfaces;

import java.util.List;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.enums.DamageType;

public interface WeaponType {

    String getName();

    String getDescription();

    AttackStats getAttackStats();

    DefenseStats getDefenseStats();

    MagicStats getMagicStats();

    double getDurability();

    List<DamageType> getDamageTypes();

}
