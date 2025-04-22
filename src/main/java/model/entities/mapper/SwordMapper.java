package model.entities.mapper;

import model.entities.domain.sword.Sword;
import model.entities.persistence.sword.PersistenceSword;
import model.interfaces.Mapper;

public class SwordMapper implements Mapper<Sword, PersistenceSword> {

    @Override
    public Sword toDomain(PersistenceSword entity) {
        return new Sword(
                entity.getId(),
                entity.getNome(),
                entity.getDescription(),
                entity.getSwordType(),
                entity.getMetal()
        );
    }

    @Override
    public PersistenceSword toEntity(Sword domain) {
        return new PersistenceSword(
                domain.getId(),
                domain.getNome(),
                domain.getDescription(),
                domain.getSwordType(),
                domain.getMetals()
        );
    }
}
