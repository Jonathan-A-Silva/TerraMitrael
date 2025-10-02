package model.enums.resources;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ResourceType;

public enum Metals implements ResourceType {

    COPPER(
            "Copper",
            "That's a simple Metal",
            1.0f,
            1.62f,
            new CombatStatus(0.5, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    );

    private final String name;
    private final String description;
    private final float minResourceWeight;
    private final float maxResourceWeight;
    private final CombatStatus combatStatus;

    Metals(String name, String description, float minResourceWeight, float maxResourceWeight, CombatStatus combatStatus) {
        this.name = name;
        this.description = description;
        this.minResourceWeight = minResourceWeight;
        this.maxResourceWeight = maxResourceWeight;
        this.combatStatus = combatStatus;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getMinResourceWeight() {
        return minResourceWeight;
    }

    @Override
    public float getMaxResourceWeight() {
        return maxResourceWeight;
    }

    @Override
    public CombatStatus getCombatStatus() {
        return combatStatus;
    }

}
