package model.factory.connection;

import model.persistence.encryption.Encryption;
import model.persistence.image.Image;
import model.persistence.item.PersistenceItem;
import model.persistence.person.Person;
import model.persistence.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionFactory {

    public SessionFactory getConexao() {

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Encryption.class);
        configuration.addAnnotatedClass(Image.class);
        configuration.addAnnotatedClass(PersistenceItem.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(User.class);

        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}