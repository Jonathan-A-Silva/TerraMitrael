package model.enums.resources;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ResourceType;

public enum Woods implements ResourceType {

    PINE(
            "Pine",
            "A light and flexible wood. Easy to work with but not very durable.",
            1.0f,
            1.25f,
            new CombatStatus.Builder()
                    .attack(0.9, 1.1, 1.0, 0.9, 0.9)
                    .control(1.1, 1.2, 1.0)
                    .defense(0.7, 0.8, 0.9, 0.8)
                    .vitality(0.9, 1.0, 0.9, 1.0, 1.0)
                    .magic(1.0, 1.0, 1.0, 1.0, 1.0)
                    .build()
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