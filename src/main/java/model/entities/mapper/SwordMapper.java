package model.entities.mapper;

import model.entities.domain.sword.Sword;
import model.entities.persistence.sword.PersistenceSword;
import model.interfaces.Mapper;

public class SwordMapper implements Mapper<Sword, PersistenceSword> {

    @Override
    public Sword toDomain(PersistenceSword entity) {
        return new Sword(
                entity.getSwordType(),
                entity.getBlade(),
                entity.getGuard(),
                entity.getHandler()
        );
    }

    @Override
    public PersistenceSword toEntity(Sword domain) {
        return new PersistenceSword(
                domain.getSwordType(),
                domain.getBlade(),
                domain.getGuard(),
                domain.getHandler()
        );
    }
}
