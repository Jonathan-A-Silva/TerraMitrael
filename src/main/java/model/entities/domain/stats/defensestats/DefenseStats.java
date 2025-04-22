package model.entities.domain.stats.defensestats;

public class DefenseStats {
    private final double armor;
    private final double resistance;
    private final double weight;

    public DefenseStats(double armor, double resistance, double weight) {
        this.armor = armor;
        this.resistance = resistance;
        this.weight = weight;
    }

    public double getArmor() {
        return armor;
    }

    public double getResistance() {
        return resistance;
    }

    public double getWeight() {
        return weight;
    }

}
