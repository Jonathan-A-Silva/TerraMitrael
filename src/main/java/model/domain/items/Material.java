package model.domain.items;

import model.domain.stats.CombatStatus;
import model.exceptions.item.ItemException;
import model.interfaces.Types.MaterialType;

public class Material extends Item implements MaterialType {

    private final MaterialType materialType;
    private final Resource resource;
    private final CombatStatus combatStatus;

    public Material(MaterialType materialType, Resource resource) {
        super(materialType.getName(), materialType.getDescription(), 1, 1, (resource.getWeight() * materialType.getResourcesToCraft()));

        if (resource.getQuantity() != materialType.getResourcesToCraft()) {
            throw new ItemException(
                    "Resource quantity does not match Material requirement.\n" +
                            "Resources: " + resource.getQuantity() + "\n" +
                            "Required: " + materialType.getResourcesToCraft()
            );
        }

        this.materialType = materialType;
        this.resource = resource;
        this.combatStatus = new CombatStatus();

        for (int i = 0; i < materialType.getResourcesToCraft(); i++) {
            combatStatus.mergeStatus(resource.getCombatStatus());
        }

    }

    @Override
    public int getResourcesToCraft() {
        return materialType.getResourcesToCraft();
    }

    @Override
    public MaterialType getMaterialType() {
        return materialType;
    }

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public CombatStatus getCombatStatus() {
        return combatStatus;
    }

}
