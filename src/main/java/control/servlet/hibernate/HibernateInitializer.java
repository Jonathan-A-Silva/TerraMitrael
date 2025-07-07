package control.servlet.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.entities.persistence.encryption.Encryption;
import model.entities.persistence.user.User;
import model.factory.connection.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebListener
public class HibernateInitializer implements ServletContextListener {

    private SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        sessionFactory = connectionFactory.getConexao();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User existente = session.get(User.class, 1L);

            if (existente == null) {
                Encryption encryption = new Encryption();
                User admin = new User(1, "jonathan.alfredodasilva2001@gmail.com", "JowSnow", "123", encryption);

                session.save(encryption);
                session.save(admin);
                session.getTransaction().commit();

                System.out.println("Usuário padrão criado com sucesso.");
            } else {
                session.getTransaction().rollback();
                System.out.println("Usuário padrão já existe.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao criar usuário padrão: " + e.getMessage());
            throw new RuntimeException("Erro ao inicializar Hibernate", e);
        }

        System.out.println("Hibernate inicializado.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {

            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
                System.out.println("SessionFactory fechado com sucesso.");
            }
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("Cleanup do MySQL encerrado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
