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
                swordType.getName(),
                swordType.getDescription(),
                calculateAttackDamage(swordType, blade, guard, handler),
                calculateAttackSpeed(swordType, blade, guard, handler),
                calculateCriticalChance(swordType, blade, guard, handler),
                calculateCriticalDamage(swordType, blade, guard, handler),
                calculateDurability(swordType, blade, guard, handler),
                swordType.getDamageTypes()
        );

        if (blade.likeBlade() && guard.likeGuard() && handler.likeHandle()) {
            this.swordType = swordType;
            this.blade = blade;
            this.guard = guard;
            this.handler = handler;
        } else {
            throw new IllegalArgumentException("The selected materials are not compatible to assemble a sword!");
        }
    }

    private static double calculateAttackDamage(SwordType type, MaterialType blade, MaterialType guard, MaterialType handle) {
        double base = blade.getAttackStats().getDamage()
                + guard.getAttackStats().getDamage()
                + handle.getAttackStats().getDamage();
        return base * type.getAttack_damage_multiplier();
    }

    private static double calculateAttackSpeed(SwordType type, MaterialType blade, MaterialType guard, MaterialType handle) {
        double base = blade.getAttackStats().getSpeed()
                + guard.getAttackStats().getSpeed()
                + handle.getAttackStats().getSpeed();
        return base * type.getAttack_speed_multiplier();
    }

    private static double calculateCriticalChance(SwordType type, MaterialType blade, MaterialType guard, MaterialType handle) {
        double base = blade.getAttackStats().getCriticalChance()
                + guard.getAttackStats().getCriticalChance()
                + handle.getAttackStats().getCriticalChance();
        return base * type.getCritical_chance_multiplier();
    }

    private static double calculateCriticalDamage(SwordType type, MaterialType blade, MaterialType guard, MaterialType handle) {
        double base = blade.getAttackStats().getCriticalDamage()
                + guard.getAttackStats().getCriticalDamage()
                + handle.getAttackStats().getCriticalDamage();
        return base * type.getCritical_damage_multiplier();
    }

    private static double calculateDurability(SwordType type, MaterialType blade, MaterialType guard, MaterialType handle) {
        double base = blade.getDurability()
                + guard.getDurability()
                + handle.getDurability();
        return base * type.getDurability_multiplier();
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
