package model.entities.persistence.sword;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import model.entities.persistence.item.PersistenceItem;
import model.enums.SwordType;
import model.interfaces.MaterialType;

@Entity
@Table(name = "swords")
public class PersistenceSword extends PersistenceItem {

    @Enumerated(EnumType.STRING)
    @Column(name = "sword_type", nullable = false)
    private SwordType swordType;

    @Enumerated(EnumType.STRING)
    @Column(name = "blade_metal", nullable = false)
    private MaterialType blade;

    @Enumerated(EnumType.STRING)
    @Column(name = "guard_metal", nullable = false)
    private MaterialType guard;

    @Enumerated(EnumType.STRING)
    @Column(name = "handler_metal", nullable = false)
    private MaterialType handler;

    public PersistenceSword() {
    }

    public PersistenceSword(SwordType swordType, MaterialType blade, MaterialType guard, MaterialType handler) {
        super(swordType.name(), "Teste");
        this.swordType = swordType;
        this.blade = blade;
        this.guard = guard;
        this.handler = handler;
    }

    public PersistenceSword(long id, SwordType swordType, MaterialType blade, MaterialType guard, MaterialType handler) {
        super(id, swordType.name(), "Teste");
        this.swordType = swordType;
        this.blade = blade;
        this.guard = guard;
        this.handler = handler;
    }

    public SwordType getSwordType() {
        return swordType;
    }

    public void setSwordType(SwordType swordType) {
        this.swordType = swordType;
    }

    public MaterialType getBlade() {
        return blade;
    }

    public void setBlade(MaterialType blade) {
        this.blade = blade;
    }

    public MaterialType getGuard() {
        return guard;
    }

    public void setGuard(MaterialType guard) {
        this.guard = guard;
    }

    public MaterialType getHandler() {
        return handler;
    }

    public void setHandler(MaterialType handler) {
        this.handler = handler;
    }

}
