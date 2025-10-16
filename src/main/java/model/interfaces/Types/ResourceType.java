package model.interfaces.Types;

import model.domain.stats.CombatStatus;
import model.enums.DamageType;

import java.util.Map;

public interface ResourceType {

    String getName();

    String getDescription();

    float getMinResourceWeight();

    float getMaxResourceWeight();

    CombatStatus getCombatStatus();

}
