package model.persistence.stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "defense_stats")
public class PersistenceDefenseStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "life")
    private Double life;

    @Column(name = "armor")
    private Double armor;

    @Column(name = "resistance")
    private Double resistance;

    @Column(name = "stamina")
    private Double stamina;

    public PersistenceDefenseStats() {
    }

    public PersistenceDefenseStats(Double life, Double armor, Double resistance, Double stamina) {
        this.life = life;
        this.armor = armor;
        this.resistance = resistance;
        this.stamina = stamina;
    }

    public Long getId() {
        return id;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }

    public Double getStamina() {
        return stamina;
    }

    public void setStamina(Double stamina) {
        this.stamina = stamina;
    }
}
