package model.domain.worktables;

import java.util.Map;
import java.util.Random;

import model.domain.items.RawResource;
import model.domain.items.Resource;

public abstract class WorkTables {

    public Map<RawResource, Resource> processResource(RawResource rawResource) {
        Random random = new Random();
        int quantity = 0;
        while (rawResource.getWeight() > rawResource.getMinResourceWeight()) {
            double remainingWeight = rawResource.getWeight();
            double costWeight = random.nextDouble(rawResource.getMinResourceWeight(), rawResource.getMaxResourceWeight());
            if (remainingWeight < costWeight) {
                break;
            }
            rawResource.setWeight(remainingWeight - costWeight);
            quantity++;
        }
        return Map.of(rawResource, new Resource(rawResource, quantity));
    }

        

}
