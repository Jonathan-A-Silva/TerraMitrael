package model.entities.domain.stats.magicalstats;

public class MagicStats {
    private final double spellPower;
    private final double manaRegen;

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
}
