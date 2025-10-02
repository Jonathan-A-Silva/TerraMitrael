package model.enums.materials;

import model.interfaces.Types.MaterialType;

public enum SwordMaterial implements MaterialType {

    CABLE("Cable", "Test", 1);

    private final String name;
    private final String description;
    private final int resourceToCraft;

    SwordMaterial(String name, String description, int resourceToCraft) {
        this.name = name;
        this.description = description;
        this.resourceToCraft = resourceToCraft;
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
    public int getResourcesToCraft() {
        return resourceToCraft;
    }

}
