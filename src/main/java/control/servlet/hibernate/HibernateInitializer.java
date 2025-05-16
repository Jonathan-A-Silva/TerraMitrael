package control.servlet.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebListener
public class HibernateInitializer implements ServletContextListener {

    private static SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
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
