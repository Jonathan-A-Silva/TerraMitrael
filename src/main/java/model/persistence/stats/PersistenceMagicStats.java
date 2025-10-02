package model.persistence.stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magic_stats")
public class PersistenceMagicStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spell_power")
    private Double spellPower;

    @Column(name = "mana")
    private Double mana;

    @Column(name = "mana_regen")
    private Double manaRegen;

    public PersistenceMagicStats() {
    }

    public PersistenceMagicStats(Double spellPower, Double manaRegen) {
        this.spellPower = spellPower;
        this.manaRegen = manaRegen;
    }

    public Long getId() {
        return id;
    }

    public Double getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(Double spellPower) {
        this.spellPower = spellPower;
    }

    public Double getMana() {
        return mana;
    }

    public void setMana(Double mana) {
        this.mana = mana;
    }

    public Double getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(Double manaRegen) {
        this.manaRegen = manaRegen;
    }

}
