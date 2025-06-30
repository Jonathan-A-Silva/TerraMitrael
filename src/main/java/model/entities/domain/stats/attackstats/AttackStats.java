package model.entities.domain.stats.attackstats;

public class AttackStats {
    private double damage;
    private double speed;
    private double criticalChance;
    private double criticalDamage;

    public AttackStats() {
    }

    public AttackStats(double damage, double speed, double criticalChance, double criticalDamage) {
        this.damage = damage;
        this.speed = speed;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public double getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public void mergeStatus(AttackStats attackStats) {
        this.damage += attackStats.getDamage();
        this.speed += attackStats.getSpeed();
        this.criticalChance += attackStats.getCriticalChance();
        this.criticalDamage += attackStats.getCriticalDamage();
    }

    public void multiplierStatus(AttackStats attackStats) {
        this.damage *= attackStats.getDamage();
        this.speed *= attackStats.getSpeed();
        this.criticalChance *= attackStats.getCriticalChance();
        this.criticalDamage *= attackStats.getCriticalDamage();
    }

}
