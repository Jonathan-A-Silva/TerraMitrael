package model.entities.domain.stats.attackstats;

public class AttackStats {
    private final double damage;
    private final double speed;
    private final double criticalChance;
    private final double criticalDamage;

    public AttackStats(double damage, double speed, double criticalChance, double criticalDamage) {
        this.damage = damage;
        this.speed = speed;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
    }

    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public double getCriticalDamage() {
        return criticalDamage;
    }
}
