package model.domain.stats;

public class CombatStatus {

    // ---- Attack ----
    private double damage;
    private double speed;
    private double criticalChance;
    private double criticalDamage;
    private double armorPenetration;

    // ---- Control ----
    private double accuracy;
    private double evasion;
    private double controlPower;

    // ---- Defense ----
    private double hardness;
    private double elasticity;
    private double conductivity;
    private double tenacity;

    // ---- Vitality ----
    private double life;
    private double lifeRegen;
    private double resistance;
    private double stamina;
    private double staminaRegen;

    // ---- Magic ----
    private double spellPower;
    private double mana;
    private double manaRegen;
    private double magicPenetration;
    private double magicConversion;

    public CombatStatus() {
        this.damage = 0;
        this.speed = 0;
        this.criticalChance = 0;
        this.criticalDamage = 0;
        this.armorPenetration = 0;

        this.accuracy = 0;
        this.evasion = 0;
        this.controlPower = 0;

        this.hardness = 0;
        this.elasticity = 0;
        this.conductivity = 0;
        this.tenacity = 0;

        this.life = 0;
        this.lifeRegen = 0;
        this.resistance = 0;
        this.stamina = 0;
        this.staminaRegen = 0;

        this.spellPower = 0;
        this.mana = 0;
        this.manaRegen = 0;
        this.magicPenetration = 0;
        this.magicConversion = 0;
    }

    // ===== BUILDER =====
    public static class Builder {

        // ---- Attack ----
        private double damage;
        private double speed;
        private double criticalChance;
        private double criticalDamage;
        private double armorPenetration;

        // ---- Control ----
        private double accuracy;
        private double evasion;
        private double controlPower;

        // ---- Defense ----
        private double hardness;
        private double elasticity;
        private double conductivity;
        private double tenacity;

        // ---- Vitality ----
        private double life;
        private double lifeRegen;
        private double resistance;
        private double stamina;
        private double staminaRegen;

        // ---- Magic ----
        private double spellPower;
        private double mana;
        private double manaRegen;
        private double magicPenetration;
        private double magicConversion;

        public Builder attack(double damage, double speed, double criticalChance, double criticalDamage, double armorPenetration) {
            this.damage = damage;
            this.speed = speed;
            this.criticalChance = criticalChance;
            this.criticalDamage = criticalDamage;
            this.armorPenetration = armorPenetration;
            return this;
        }

        public Builder control(double accuracy, double evasion, double controlPower) {
            this.accuracy = accuracy;
            this.evasion = evasion;
            this.controlPower = controlPower;
            return this;
        }

        public Builder defense(double hardness, double elasticity, double conductivity, double tenacity) {
            this.hardness = hardness;
            this.elasticity = elasticity;
            this.conductivity = conductivity;
            this.tenacity = tenacity;
            return this;
        }

        public Builder vitality(double life, double lifeRegen, double resistance, double stamina, double staminaRegen) {
            this.life = life;
            this.lifeRegen = lifeRegen;
            this.resistance = resistance;
            this.stamina = stamina;
            this.staminaRegen = staminaRegen;
            return this;
        }

        public Builder magic(double spellPower, double mana, double manaRegen, double magicPenetration, double magicConversion) {
            this.spellPower = spellPower;
            this.mana = mana;
            this.manaRegen = manaRegen;
            this.magicPenetration = magicPenetration;
            this.magicConversion = magicConversion;
            return this;
        }

        public CombatStatus build() {
            return new CombatStatus(this);
        }
    }

    private CombatStatus(Builder builder) {
        // Attack
        this.damage = builder.damage;
        this.speed = builder.speed;
        this.criticalChance = builder.criticalChance;
        this.criticalDamage = builder.criticalDamage;
        this.armorPenetration = builder.armorPenetration;

        // Control
        this.accuracy = builder.accuracy;
        this.evasion = builder.evasion;
        this.controlPower = builder.controlPower;

        // Defense
        this.hardness = builder.hardness;
        this.elasticity = builder.elasticity;
        this.conductivity = builder.conductivity;
        this.tenacity = builder.tenacity;

        // Vitality
        this.life = builder.life;
        this.lifeRegen = builder.lifeRegen;
        this.resistance = builder.resistance;
        this.stamina = builder.stamina;
        this.staminaRegen = builder.staminaRegen;

        // Magic
        this.spellPower = builder.spellPower;
        this.mana = builder.mana;
        this.manaRegen = builder.manaRegen;
        this.magicPenetration = builder.magicPenetration;
        this.magicConversion = builder.magicConversion;
    }

    public void mergeStatus(CombatStatus other) {
        if (other == null) return;

        // Attack
        this.damage += other.damage;
        this.speed += other.speed;
        this.criticalChance += other.criticalChance;
        this.criticalDamage += other.criticalDamage;
        this.armorPenetration += other.armorPenetration;

        // Control
        this.accuracy += other.accuracy;
        this.evasion += other.evasion;
        this.controlPower += other.controlPower;

        // Defense
        this.hardness += other.hardness;
        this.elasticity += other.elasticity;
        this.conductivity += other.conductivity;
        this.tenacity += other.tenacity;

        // Vitality
        this.life += other.life;
        this.lifeRegen += other.lifeRegen;
        this.resistance += other.resistance;
        this.stamina += other.stamina;
        this.staminaRegen += other.staminaRegen;

        // Magic
        this.spellPower += other.spellPower;
        this.mana += other.mana;
        this.manaRegen += other.manaRegen;
        this.magicPenetration += other.magicPenetration;
        this.magicConversion += other.magicConversion;
    }

    public void multiplierStatus(CombatStatus other) {
        if (other == null) return;

        // Attack
        this.damage *= other.damage;
        this.speed *= other.speed;
        this.criticalChance *= other.criticalChance;
        this.criticalDamage *= other.criticalDamage;
        this.armorPenetration *= other.armorPenetration;

        // Control
        this.accuracy *= other.accuracy;
        this.evasion *= other.evasion;
        this.controlPower *= other.controlPower;

        // Defense
        this.hardness *= other.hardness;
        this.elasticity *= other.elasticity;
        this.conductivity *= other.conductivity;
        this.tenacity *= other.tenacity;

        // Vitality
        this.life *= other.life;
        this.lifeRegen *= other.lifeRegen;
        this.resistance *= other.resistance;
        this.stamina *= other.stamina;
        this.staminaRegen *= other.staminaRegen;

        // Magic
        this.spellPower *= other.spellPower;
        this.mana *= other.mana;
        this.manaRegen *= other.manaRegen;
        this.magicPenetration *= other.magicPenetration;
        this.magicConversion *= other.magicConversion;
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

    public double getArmorPenetration() {
        return armorPenetration;
    }

    public void setArmorPenetration(double armorPenetration) {
        this.armorPenetration = armorPenetration;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getEvasion() {
        return evasion;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public double getControlPower() {
        return controlPower;
    }

    public void setControlPower(double controlPower) {
        this.controlPower = controlPower;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getElasticity() {
        return elasticity;
    }

    public void setElasticity(double elasticity) {
        this.elasticity = elasticity;
    }

    public double getConductivity() {
        return conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    public double getTenacity() {
        return tenacity;
    }

    public void setTenacity(double tenacity) {
        this.tenacity = tenacity;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double getLifeRegen() {
        return lifeRegen;
    }

    public void setLifeRegen(double lifeRegen) {
        this.lifeRegen = lifeRegen;
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

    public double getStaminaRegen() {
        return staminaRegen;
    }

    public void setStaminaRegen(double staminaRegen) {
        this.staminaRegen = staminaRegen;
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

    public double getMagicPenetration() {
        return magicPenetration;
    }

    public void setMagicPenetration(double magicPenetration) {
        this.magicPenetration = magicPenetration;
    }

    public double getMagicConversion() {
        return magicConversion;
    }

    public void setMagicConversion(double magicConversion) {
        this.magicConversion = magicConversion;
    }

}
