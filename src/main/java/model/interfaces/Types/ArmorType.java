package model.interfaces.Types;

import java.util.List;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;

public interface ArmorType {

    String getName();

    String getDescription();

    CombatStatus getCombatStatus();

    double getDurability();

    List<DamageType> getDefenseTypes();

}
