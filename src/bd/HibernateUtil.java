package bd;

/**
 * Created by tttt on 21.11.2016.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.io.File;

import static java.lang.System.*;

public class HibernateUtil {
    private static final StandardServiceRegistry serviceRegistry = CreateServiceRegistry();

    private static StandardServiceRegistry CreateServiceRegistry(){
        StandardServiceRegistry s = new StandardServiceRegistryBuilder().configure().build();
        return s;
    }

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory()
    {
        try {
            return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }
        catch (Throwable ex) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
