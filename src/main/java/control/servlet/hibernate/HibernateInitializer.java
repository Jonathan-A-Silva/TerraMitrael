package control.servlet.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.entities.persistence.encryption.Encryption;
import model.entities.persistence.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebListener
public class HibernateInitializer implements ServletContextListener {

    private static SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Session session = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

            try {
                session = sessionFactory.openSession();
                session.beginTransaction();

                Encryption encryption = new Encryption();
                User admin = new User(1, "JowSnow", "123", encryption);

                session.save(encryption);
                session.save(admin);

                session.getTransaction().commit();
                System.out.println("Feito o cadastro do padrão");
            }catch (Exception e){
                System.out.println("Usuário Padrão já cadastrado.");
            }

            sessionFactory.openSession().close();
            System.out.println("Hibernate inicializado e schema gerado.");
        } catch (Throwable ex) {
            System.err.println("Erro ao inicializar o Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
