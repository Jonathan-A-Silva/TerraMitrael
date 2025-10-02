package model.interfaces.Types;

import model.domain.items.Resource;
import model.domain.stats.CombatStatus;

public interface MaterialType {

    String getName();

    String getDescription();

    int getResourcesToCraft();

    MaterialType getMaterialType();

    Resource getResource();

    CombatStatus getCombatStatus();

}
