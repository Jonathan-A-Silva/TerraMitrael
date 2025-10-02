package model.interfaces.Types;

import model.domain.stats.CombatStatus;

public interface ResourceType {

    String getName();

    String getDescription();

    float getMinResourceWeight();

    float getMaxResourceWeight();

    CombatStatus getCombatStatus();

}
