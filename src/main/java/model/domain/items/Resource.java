package model.domain.items;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ResourceType;

public class Resource extends Item implements ResourceType {

    private final ResourceType resource;

    public Resource(RawResource raw, int quantity) {
        super(raw.getName(), raw.getDescription(), quantity, 99, calculeWeight(raw));
        this.resource = raw;
    }

    @Override
    public float getMinResourceWeight() {
        return resource.getMinResourceWeight();
    }

    @Override
    public float getMaxResourceWeight() {
        return resource.getMaxResourceWeight();
    }

    @Override
    public CombatStatus getCombatStatus() {
        return resource.getCombatStatus();
    }

    private static double calculeWeight(RawResource raw) {
        return (raw.getMinResourceWeight() + raw.getMaxResourceWeight()) / 2;
    }

}
