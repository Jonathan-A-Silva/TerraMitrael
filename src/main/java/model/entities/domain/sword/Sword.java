package model.entities.domain.sword;

import model.entities.domain.weapon.Weapon;
import model.enums.SwordType;
import model.interfaces.MaterialType;

public class Sword extends Weapon {

    private final SwordType swordType;
    private final MaterialType blade;
    private final MaterialType guard;
    private final MaterialType handler;

    public Sword(SwordType swordType, MaterialType blade, MaterialType guard, MaterialType handler) {
        super(
                swordType.name(),
                "Descrição qualquer",
                calculateAttackDamage(blade, guard, handler),
                calculateAttackSpeed(blade, guard, handler),
                calculateCriticalChance(blade, guard, handler),
                calculateCriticalDamage(blade, guard, handler),
                calculateDurability(blade, guard, handler),
                swordType.getDamageTypes()
        );

        if (blade.likeBlade() && guard.likeGuard() && handler.likeHandle()) {
            this.swordType = swordType;
            this.blade = blade;
            this.guard = guard;
            this.handler = handler;
        }else {
            throw new IllegalArgumentException("Os materiais escolhidos não são compatíveis para montar a espada!");
        }

    }

    private static double calculateAttackDamage(MaterialType blade, MaterialType guard, MaterialType handle) {
        return blade.getAttackStats().getDamage()
                + guard.getAttackStats().getDamage()
                + handle.getAttackStats().getDamage();
    }

    private static double calculateAttackSpeed(MaterialType blade, MaterialType guard, MaterialType handle) {
        return blade.getAttackStats().getSpeed()
                + guard.getAttackStats().getSpeed()
                + handle.getAttackStats().getSpeed();
    }

    private static double calculateCriticalChance(MaterialType blade, MaterialType guard, MaterialType handle) {
        return blade.getAttackStats().getCriticalChance()
                + guard.getAttackStats().getCriticalChance()
                + handle.getAttackStats().getCriticalChance();
    }

    private static double calculateCriticalDamage(MaterialType blade, MaterialType guard, MaterialType handle) {
        return blade.getAttackStats().getCriticalDamage()
                + guard.getAttackStats().getCriticalDamage()
                + handle.getAttackStats().getCriticalDamage();
    }

    private static double calculateDurability(MaterialType blade, MaterialType guard, MaterialType handle) {
        return blade.getDurability()
                + guard.getDurability()
                + handle.getDurability();
    }

    public SwordType getSwordType() {
        return swordType;
    }

    public MaterialType getBlade() {
        return blade;
    }

    public MaterialType getGuard() {
        return guard;
    }

    public MaterialType getHandler() {
        return handler;
    }

}
