package model.dao.user;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.entities.persistence.user.User;
import model.entities.persistence.user.User_;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import util.DAOUtil;


public class UserDAOImpl implements UserDAO {

    private final ConnectionFactory factory;

    public UserDAOImpl() {
        factory = new ConnectionFactory();
    }

    public void saveUser(User User) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.save(User);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
            throw exception;
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public void deleteUser(User User) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.delete(User);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public void updateUser(User User) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.update(User);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    public User getUserForNickname(String nickname) {
        Session session = null;
        User UserRecuperado = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            CriteriaBuilder construtor = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = construtor.createQuery(User.class);
            Root<User> raizUser = criteria.from(User.class);
            criteria.select(raizUser).where(construtor.equal(raizUser.get(User_.NICKNAME), nickname));
            UserRecuperado = session.createQuery(criteria).getSingleResult();
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
        return UserRecuperado;
    }

}
