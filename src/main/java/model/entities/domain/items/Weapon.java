package model.entities.domain.items;

import java.util.List;

import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.enums.DamageType;
import model.interfaces.MaterialType;
import model.interfaces.WeaponType;

public abstract class Weapon extends Item {

    private AttackStats attackStats;
    private MagicStats magicStats;
    private List<DamageType> damageType;
    private int durability;
    private int max_durability;

    public Weapon(String name, String description, int quantity, int max_quantity, double weight, AttackStats attackStats, MagicStats magicStats, List<DamageType> damageType, int durability, int max_durability) {
        super(name, description, quantity, max_quantity, weight);
        this.attackStats = attackStats;
        this.magicStats = magicStats;
        this.damageType = damageType;
        this.durability = durability;
        this.max_durability = max_durability;
    }

    public AttackStats getAttackStats() {
        return attackStats;
    }

    public void setAttackStats(AttackStats attackStats) {
        this.attackStats = attackStats;
    }

    public MagicStats getMagicStats() {
        return magicStats;
    }

    public void setMagicStats(MagicStats magicStats) {
        this.magicStats = magicStats;
    }

    public List<DamageType> getDamageType() {
        return damageType;
    }

    public void setDamageType(List<DamageType> damageType) {
        this.damageType = damageType;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getMax_durability() {
        return max_durability;
    }

    public void setMax_durability(int max_durability) {
        this.max_durability = max_durability;
    }

    protected static double mergeWeight(MaterialType blade, MaterialType guard, MaterialType handler) {
        return blade.getWeight() + guard.getWeight() + handler.getWeight();
    }

    protected static AttackStats mergeAttackStatus(WeaponType weaponType, MaterialType blade, MaterialType guard, MaterialType handler) {
        AttackStats attackStats = new AttackStats();
        List<MaterialType> materialTypes = List.of(blade, guard, handler);

        for (MaterialType material : materialTypes) {
            if (material.getAttackStats() != null) {
                attackStats.mergeStatus(material.getAttackStats());
            }
        }

        attackStats.multiplierStatus(weaponType.getAttackStats());

        return attackStats;
    }

    protected static MagicStats mergeMagicStats(MaterialType blade, MaterialType guard, MaterialType handler) {
        MagicStats magicStats = new MagicStats();
        List<MaterialType> materialTypes = List.of(blade, guard, handler);

        for (MaterialType material : materialTypes) {
            if (material.getMagicStats() != null) {
                magicStats.mergeStatus(material.getMagicStats());
            }
        }

        return magicStats;
    }

    protected static int mergeDurabulity(WeaponType weaponType, MaterialType blade, MaterialType guard, MaterialType handler) {
        return (int) (weaponType.getDurability() * (blade.getDurability() + guard.getDurability() + handler.getDurability()));
    }

}
