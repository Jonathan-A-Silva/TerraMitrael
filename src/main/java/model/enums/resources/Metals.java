package model.enums.resources;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ResourceType;

public enum Metals implements ResourceType {

    COPPER(
            "Copper",
            "That's a simple Metal",
            1.0f,
            1.62f,
            new CombatStatus.Builder()
                    .attack(0.5, 0.8, 0.05, 1.1, 0.2)
                    .control(0.6, 0.4, 0.3)
                    .defense(0.3, 0.7, 1.0, 0.5)
                    .vitality(0.5, 0.3, 0.4, 0.6, 0.5)
                    .magic(0.7, 0.4, 0.6, 0.8, 0.5)
                    .build()
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
