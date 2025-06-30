package model.entities.domain.items;

import model.enums.MaterialRole;
import model.enums.SwordType;
import model.exceptions.Weapon.CreateWeaponException;
import model.interfaces.MaterialType;

public class Sword extends Weapon {

    private final SwordType swordType;
    private final MaterialType blade;
    private final MaterialType guard;
    private final MaterialType handler;

    public Sword(SwordType swordType, MaterialType blade, MaterialType guard, MaterialType handler) {
        super(swordType.getName(),
                swordType.getDescription(),
                1,
                1,
                mergeWeight(blade, guard, handler),
                mergeAttackStatus(swordType, blade, guard, handler),
                mergeMagicStats(blade, guard, handler),
                swordType.getDamageTypes(),
                mergeDurabulity(swordType, blade, guard, handler),
                mergeDurabulity(swordType, blade, guard, handler)
        );

        if (blade.utilities().canBeUsedAs(MaterialRole.BLADE) && guard.utilities().canBeUsedAs(MaterialRole.GUARD) && handler.utilities().canBeUsedAs(MaterialRole.HANDLE)) {
            this.swordType = swordType;
            this.blade = blade;
            this.guard = guard;
            this.handler = handler;
        } else {
            throw new CreateWeaponException("The selected materials are not compatible to assemble a sword!");
        }
    }


}
