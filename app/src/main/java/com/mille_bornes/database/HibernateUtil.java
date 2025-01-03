package com.mille_bornes.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Utility class for managing Hibernate SessionFactory.
 * 
 * This class initializes the Hibernate SessionFactory during class loading
 * and provides methods to access and close the SessionFactory.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final Class<?>[] classes = {
        com.mille_bornes.database.data.Game.class,
        com.mille_bornes.database.data.Round.class,
        com.mille_bornes.database.data.DeckCard.class,
        com.mille_bornes.database.data.StackCard.class,
        com.mille_bornes.database.data.HandCard.class,
        com.mille_bornes.database.data.Player.class,
    };

    static {
        try {
            // Load the Hibernate configuration from hibernate.cfg.xml.
            Configuration configuration = new Configuration();
            configuration = configuration.configure();
            // Add annotated classes to the configuration.
            for (final Class<?> annotatedClass : HibernateUtil.classes)
                configuration.addAnnotatedClass(annotatedClass);
            // Create the SessionFactory from hibernate.cfg.xml.
            sessionFactory = configuration.buildSessionFactory((
                new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build()
            ));
        } catch (final Throwable exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    /**
     * Opens a new Hibernate Session from the SessionFactory.
     * 
     * @return a new Hibernate Session.
     */
    public static Session open() {
        return HibernateUtil.sessionFactory.openSession();
    }

    /**
     * Ensures the SessionFactory is closed when the instance is garbage 
     * collected.
     */
    @Override
    protected void finalize() throws Throwable {
        try {
            HibernateUtil.sessionFactory.close();
        } catch (final Throwable exception) {
            System.err.println(exception);
        }
    }
}
