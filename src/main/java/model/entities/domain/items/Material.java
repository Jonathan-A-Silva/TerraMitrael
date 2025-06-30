package model.entities.domain.items;

import util.MaterialUtilities;
import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.interfaces.MaterialType;

public class Material extends Item implements MaterialType {

    private final MaterialType type;

    public Material(MaterialType type, int quantity) {
        super(type.getName(), type.getDescription(), quantity, type.getMaxQuantity(), type.getWeight());
        this.type = type;
    }

    @Override
    public int getMaxQuantity() {
        return type.getMaxQuantity();
    }

    @Override
    public AttackStats getAttackStats() {
        return type.getAttackStats();
    }

    @Override
    public DefenseStats getDefenseStats() {
        return type.getDefenseStats();
    }

    @Override
    public MagicStats getMagicStats() {
        return type.getMagicStats();
    }

    @Override
    public MaterialUtilities utilities() {
        return type.utilities();
    }

    @Override
    public int getDurability() {
        return type.getDurability();
    }

    @Override
    public int getMaxDurability() {
        return type.getMaxDurability();
    }
}
