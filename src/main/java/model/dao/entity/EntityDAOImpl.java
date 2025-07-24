package model.dao.entity;

import model.entities.persistence.entity.PersistenceEntity;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import util.dao.DAOUtil;

public class EntityDAOImpl implements EntityDAO {

    private final ConnectionFactory factory;

    public EntityDAOImpl() {
        factory = new ConnectionFactory();
    }

    public void savePersistenceEntity(PersistenceEntity entity) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
            throw exception;
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public void deletePersistenceEntity(PersistenceEntity entity) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public void updatePersistenceEntity(PersistenceEntity entity) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }
}