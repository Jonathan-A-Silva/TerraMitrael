package model.interfaces.Types;

import java.util.List;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;

public interface WeaponType {

    String getName();

    String getDescription();

    CombatStatus getCombatStatus();

    double getDurability();

    List<DamageType> getDamageTypes();

}
