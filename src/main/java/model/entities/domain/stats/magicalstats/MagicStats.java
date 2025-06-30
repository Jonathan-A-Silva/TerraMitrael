package model.entities.domain.stats.magicalstats;

public class MagicStats {
    private double spellPower;
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

    public double getManaRegen() {
        return manaRegen;
    }

    public void mergeStatus(MagicStats magicStats) {
        this.spellPower = magicStats.getSpellPower();
        this.manaRegen = magicStats.getManaRegen();
    }

}
