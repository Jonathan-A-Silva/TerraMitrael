package model.dao.person;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.entities.persistence.person.Person;
import model.entities.persistence.person.Person_;
import model.entities.persistence.user.User;
import model.entities.persistence.user.User_;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import util.dao.DAOUtil;

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

    public List<Person> getPersonForUserId(long userId) {
        Session session = null;
        List<Person> persons;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteria = construtor.createQuery(Person.class);
            Root<Person> raizPerson = criteria.from(Person.class);
            Join<Person, User> joinUser = raizPerson.join(Person_.USER);
            criteria.select(raizPerson).where(construtor.equal(joinUser.get(User_.ID), userId));
            persons = session.createQuery(criteria).getResultList();
            session.getTransaction().commit();
        } catch (NoResultException exception) {
            persons = null;
        } catch (Exception e) {
            persons = null;
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
        return persons;
    }
}
