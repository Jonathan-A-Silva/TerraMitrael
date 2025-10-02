package model.domain.stats;

public class CombatStatus {

    // ---- Attack ----
    private double damage;
    private double speed;
    private double criticalChance;
    private double criticalDamage;

    // ---- Defense ----
    private double life;
    private double armor;
    private double resistance;
    private double stamina;

    // ---- Magic ----
    private double spellPower;
    private double mana;
    private double manaRegen;

    public CombatStatus() {
        this.damage = 0;
        this.speed = 0;
        this.criticalChance = 0;
        this.criticalDamage = 0;
        this.life = 0;
        this.armor = 0;
        this.resistance = 0;
        this.stamina = 0;
        this.spellPower = 0;
        this.mana = 0;
        this.manaRegen = 0;
    }

    public CombatStatus(double damage, double speed, double criticalChance, double criticalDamage, double life, double armor, double resistance, double stamina, double spellPower, double mana, double manaRegen) {
        this.damage = damage;
        this.speed = speed;
        this.criticalChance = criticalChance;
        this.criticalDamage = criticalDamage;
        this.life = life;
        this.armor = armor;
        this.resistance = resistance;
        this.stamina = stamina;
        this.spellPower = spellPower;
        this.mana = mana;
        this.manaRegen = manaRegen;
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

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(double spellPower) {
        this.spellPower = spellPower;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }

    public void mergeStatus(CombatStatus other) {
        if (other != null) {
            this.damage += other.getDamage();
            this.speed += other.getSpeed();
            this.criticalChance += other.getCriticalChance();
            this.criticalDamage += other.getCriticalDamage();

            this.life += other.getLife();
            this.armor += other.getArmor();
            this.resistance += other.getResistance();
            this.stamina += other.getStamina();

            this.spellPower += other.getSpellPower();
            this.mana += other.getMana();
            this.manaRegen += other.getManaRegen();
        }
    }

    public void multiplierStatus(CombatStatus other) {
        if (other != null) {
            this.damage *= other.getDamage();
            this.speed *= other.getSpeed();
            this.criticalChance *= other.getCriticalChance();
            this.criticalDamage *= other.getCriticalDamage();

            this.life *= other.getLife();
            this.armor *= other.getArmor();
            this.resistance *= other.getResistance();
            this.stamina *= other.getStamina();

            this.spellPower *= other.getSpellPower();
            this.mana *= other.getMana();
            this.manaRegen *= other.getManaRegen();
        }
    }
}
