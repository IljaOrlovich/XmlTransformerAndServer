package lt.eif.viko.iorlovic.libraryapp;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * HibernateUtil class provides utility methods for managing Hibernate SessionFactory.
 * @author Ilja
 * @version 1.0
 */
public class HibernateUtil {
    public static StandardServiceRegistry registry;

    public static SessionFactory sessionFactory;

    /**
     * Retrieves the Hibernate SessionFactory instance.
     *
     * @return The Hibernate SessionFactory instance.
     */
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();

                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    /**
     * Shuts down the Hibernate registry if it exists.
     */
    public static void shutdown(){
        if(registry!=null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
