package model.interfaces.Types;

import model.domain.stats.CombatStatus;

public interface ArmorType {

    String getName();

    String getDescription();

    CombatStatus getCombatStatus();

    double getDurability();

}
