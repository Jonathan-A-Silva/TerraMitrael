package model.entities.domain.stats.defensestats;

public class DefenseStats {
    private double life;
    private double armor;
    private double resistance;
    private double stamina;

    public DefenseStats(double life, double armor, double resistance, double stamina) {
        this.life = life;
        this.armor = armor;
        this.resistance = resistance;
        this.stamina = stamina;
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

}