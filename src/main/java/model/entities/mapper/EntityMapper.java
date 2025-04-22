package model.entities.mapper;

import model.entities.domain.entity.Entity;
import model.entities.persistence.entity.PersistenceEntity;
import model.interfaces.Mapper;

public class EntityMapper implements Mapper<Entity, PersistenceEntity> {

    @Override
    public Entity toDomain(PersistenceEntity entity) {
        return new Entity(
                entity.getId(),
                entity.getName(),
                entity.getLife(),
                entity.getStamina(),
                entity.getMana(),
                entity.getEntityClass(),
                entity.getStatusMap()
        );
    }

    @Override
    public PersistenceEntity toEntity(Entity domain) {
        return new PersistenceEntity(
                domain.getId(),
                domain.getName(),
                domain.getLife(),
                domain.getStamina(),
                domain.getMana(),
                domain.getEntityClass(),
                domain.getStatusMap()
        );
    }

}
