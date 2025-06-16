package model.dao.encryption;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.entities.persistence.encryption.Encryption;
import model.entities.persistence.user.User;
import model.entities.persistence.user.User_;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import util.DAOUtil;

public class EncryptionDAOImpl implements EncryptionDAO {

    private final ConnectionFactory factory;

    public EncryptionDAOImpl() {
        this.factory = new ConnectionFactory();
    }

    @Override
    public void saveEncryption(Encryption encryption) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.save(encryption);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
            throw exception;
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    @Override
    public void deleteEncryption(Encryption encryption) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.delete(encryption);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    @Override
    public void updateEncryption(Encryption encryption) {
        Session session = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            session.update(encryption);
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
    }

    @Override
    public Encryption getEncryptionByUserId(Long userId) {
        Session session = null;
        Encryption encryption = null;
        try {
            session = factory.getConexao().openSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Encryption> criteria = builder.createQuery(Encryption.class);
            Root<User> root = criteria.from(User.class);
            Join<User, Encryption> encryptionJoin = root.join(User_.ENCRYPTION);
            criteria.select(encryptionJoin).where(builder.equal(root.get(User_.ID), userId));
            encryption = session.createQuery(criteria).getSingleResult();
            session.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(session);
        } finally {
            DAOUtil.closeSession(session);
        }
        return encryption;
    }
}
