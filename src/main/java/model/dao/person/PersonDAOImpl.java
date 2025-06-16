package model.dao.person;

import model.entities.persistence.person.Person;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import util.DAOUtil;

public class PersonDAOImpl implements PersonDAO {

    private final ConnectionFactory factory;

    public PersonDAOImpl() {
        factory = new ConnectionFactory();
    }

    public void savePerson(Person person) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
            throw exception;
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public void deletePerson(Person person) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public void updatePerson(Person person) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }
    
}
