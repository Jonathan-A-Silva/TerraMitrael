package model.entities.persistence.sword;

import javax.persistence.*;
import model.enums.Metals;
import model.enums.SwordType;
import model.entities.persistence.item.PersistenceItem;

@Entity
@Table(name = "swords")
public class PersistenceSword extends PersistenceItem {

    @Enumerated(EnumType.STRING)
    @Column(name = "sword_type", nullable = false)
    private SwordType swordType;

    @Enumerated(EnumType.STRING)
    @Column(name = "metal", nullable = false)
    private Metals metal;

    public PersistenceSword() {
    }

    public PersistenceSword(Long id, String nome, String description, SwordType swordType, Metals metal) {
        super(id, nome, description);
        this.swordType = swordType;
        this.metal = metal;
    }

    public SwordType getSwordType() {
        return swordType;
    }

    public void setSwordType(SwordType swordType) {
        this.swordType = swordType;
    }

    public Metals getMetal() {
        return metal;
    }

    public void setMetal(Metals metal) {
        this.metal = metal;
    }
}
