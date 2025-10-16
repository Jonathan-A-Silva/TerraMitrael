package model.interfaces.Types;

import java.util.Map;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;

public interface WeaponType {

    String getName();

    String getDescription();

    CombatStatus getCombatStatus();

    double getDurability();

    Map<Float,DamageType> getDamageTypes();

}
