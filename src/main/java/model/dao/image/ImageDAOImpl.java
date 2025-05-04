package model.dao.image;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.entities.persistence.image.Image;
import model.entities.persistence.image.Image_;
import model.entities.persistence.user.User;
import model.entities.persistence.user.User_;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import util.DAOUtil;

public class ImageDAOImpl implements ImageDAO {

    private final ConnectionFactory factory;

    public ImageDAOImpl() {
        factory = new ConnectionFactory();
    }

    public void saveImage(Image image) {
        Session sessao = null;
        try {
            sessao = factory.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(image);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(sessao);
        } finally {
            DAOUtil.closeSession(sessao);
        }
    }

    public void deleteImage(Image image) {
        Session sessao = null;
        try {
            sessao = factory.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(image);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(sessao);
        } finally {
            DAOUtil.closeSession(sessao);
        }
    }

    public void updateImage(Image image) {
        Session sessao = null;
        try {
            sessao = factory.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(image);
            sessao.getTransaction().commit();
        } catch (Exception exception) {
            DAOUtil.rollBack(sessao);
        } finally {
            DAOUtil.closeSession(sessao);
        }
    }

    public Image getImageForUserNickname(String nickname) {
        Session sessao = null;
        Image getImage;
        try {
            sessao = factory.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Image> criteria = construtor.createQuery(Image.class);
            Root<Image> raizImage = criteria.from(Image.class);
            Join<Image, User> joinUser = raizImage.join(Image_.USER);
            criteria.select(raizImage).where(construtor.equal(joinUser.get(User_.NICKNAME), nickname));
            getImage = sessao.createQuery(criteria).getSingleResult();
            sessao.getTransaction().commit();
        } catch (NoResultException exception) {
            getImage = null;
        } catch (Exception exception) {
            getImage = null;
            DAOUtil.rollBack(sessao);
        } finally {
            DAOUtil.closeSession(sessao);
        }
        return getImage;
    }

}
