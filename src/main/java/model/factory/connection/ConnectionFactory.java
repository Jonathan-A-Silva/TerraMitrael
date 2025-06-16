package model.factory.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionFactory {

    public SessionFactory getConexao() {

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(model.entities.persistence.encryption.Encryption.class);
        configuration.addAnnotatedClass(model.entities.persistence.entity.PersistenceEntity.class);
        configuration.addAnnotatedClass(model.entities.persistence.image.Image.class);
        configuration.addAnnotatedClass(model.entities.persistence.person.Person.class);
        configuration.addAnnotatedClass(model.entities.persistence.user.User.class);

        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}