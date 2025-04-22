package model.entities.domain.sword;

import model.entities.domain.weapon.Weapon;
import model.enums.Metals;
import model.enums.SwordType;

public class Sword extends Weapon {

    private SwordType swordType;
    private Metals metals;

    public Sword(String nome, String description, SwordType swordType, Metals metals) {
        super(
                nome,
                description,
                swordType.getAttackDamage() + metals.getAttackDamage(),
                swordType.getAttackSpeed() + metals.getAttackSpeed(),
                swordType.getCriticalChance() + metals.getCriticalChance(),
                swordType.getCriticalDamage() + metals.getCriticalDamage(),
                swordType.getDurability() + metals.getDurability(),
                swordType.getDamageTypes()
        );
        this.swordType = swordType;
        this.metals = metals;
    }

    public Sword(long id, String nome, String description, SwordType swordType, Metals metals) {
        super(
                nome,
                description,
                swordType.getAttackDamage() + metals.getAttackDamage(),
                swordType.getAttackSpeed() + metals.getAttackSpeed(),
                swordType.getCriticalChance() + metals.getCriticalChance(),
                swordType.getCriticalDamage() + metals.getCriticalDamage(),
                swordType.getDurability() + metals.getDurability(),
                swordType.getDamageTypes()
        );
        super.setId(id);
        this.swordType = swordType;
        this.metals = metals;
    }

    public SwordType getSwordType() {
        return swordType;
    }

    public void setSwordType(SwordType swordType) {
        this.swordType = swordType;
    }

    public Metals getMetals() {
        return metals;
    }

    public void setMetals(Metals metals) {
        this.metals = metals;
    }

}
