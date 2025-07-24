package model.dao.entity;

import model.entities.persistence.entity.PersistenceEntity;

public interface EntityDAO {

    void savePersistenceEntity(PersistenceEntity entity);
    void deletePersistenceEntity(PersistenceEntity entity);
    void updatePersistenceEntity(PersistenceEntity entity);

}