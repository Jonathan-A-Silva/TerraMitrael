package model.entities.domain.material;

import model.entities.domain.item.Item;
import model.entities.domain.stats.attackstats.AttackStats;
import model.entities.domain.stats.defensestats.DefenseStats;
import model.entities.domain.stats.magicalstats.MagicStats;
import model.interfaces.MaterialType;

public class Material extends Item implements MaterialType {

    private final MaterialType type;

    public Material(MaterialType type) {
        super(type.getName(), type.getDescription());
        this.type = type;
    }

    public Material(long id, MaterialType type) {
        super(id, type.getName(), type.getDescription());
        this.type = type;
    }

    public MaterialType getType() {
        return type;
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
    public boolean likeBlade() {
        return type.likeBlade();
    }

    @Override
    public boolean likeGuard() {
        return type.likeGuard();
    }

    @Override
    public boolean likeHandle() {
        return type.likeHandle();
    }

    @Override
    public int getDurability() {
        return type.getDurability();
    }

    public String getMaterialCategory() {
        return type.getClass().getSimpleName();
    }

}
