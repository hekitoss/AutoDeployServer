package Factory;

import Entity.UsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        SessionFactory localSessionFactory = sessionFactory;
        if (localSessionFactory == null) {
            synchronized (SessionFactory.class) {
                localSessionFactory = sessionFactory;
                if (localSessionFactory == null) {
                    Configuration configuration = new Configuration();
                    configuration.configure("hibernate.cfg.xml");
                    localSessionFactory = configuration.buildSessionFactory();
                    sessionFactory = localSessionFactory;
                }
            }
        }
        return localSessionFactory;
    }
}
