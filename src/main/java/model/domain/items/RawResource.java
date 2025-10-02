package model.domain.items;

import model.domain.stats.CombatStatus;
import model.interfaces.Types.ResourceType;

public class RawResource extends Item implements ResourceType {

    private final ResourceType resource;

    public RawResource(ResourceType resource, float weight) {
        super(resource.getName(), resource.getDescription(), 1, 1, weight);
        this.resource = resource;
    }

    public ResourceType getResource() {
        return resource;
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

}
