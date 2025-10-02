package model.enums.resources;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ResourceType;

public enum Woods implements ResourceType {

    Pine(
            "pine",
            "That's a simple material.",
            1.0f,
            1.25f,
            new CombatStatus()
    );

    private final String name;
    private final String description;
    private final float minResourceWeight;
    private final float maxResourceWeight;
    private final CombatStatus combatStatus;

    Woods(String name, String description, float minResourceWeight, float maxResourceWeight, CombatStatus combatStatus) {
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