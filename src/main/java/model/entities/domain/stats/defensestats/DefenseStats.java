package model.entities.domain.stats.defensestats;

public class DefenseStats {
    private final double armor;
    private final double resistance;

    public DefenseStats(double armor, double resistance) {
        this.armor = armor;
        this.resistance = resistance;
    }

    public double getArmor() {
        return armor;
    }

    public double getResistance() {
        return resistance;
    }

}
