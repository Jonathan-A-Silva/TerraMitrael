package model.entities.domain.stats.magicalstats;

public class MagicStats {
    private double spellPower;
    private double mana;
    private double manaRegen;
    public MagicStats() {
    }

    public MagicStats(double spellPower, double manaRegen) {
        this.spellPower = spellPower;
        this.manaRegen = manaRegen;
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

    public void mergeStatus(MagicStats magicStats) {
        this.spellPower = magicStats.getSpellPower();
        this.manaRegen = magicStats.getManaRegen();
    }

}
