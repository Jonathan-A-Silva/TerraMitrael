package model.domain.items;

import model.enums.weapons.SwordType;

public class Sword extends Weapon {

    private final SwordType swordType;
    private final Material[] materials;

    public Sword(SwordType swordType, Material... materials) {
        super(swordType, materials);
        this.swordType = swordType;
        this.materials = materials;
    }

    public SwordType getSwordType() {
        return swordType;
    }

    public Material[] getMaterials() {
        return materials;
    }

}
