package com.mille_bornes.database.data;

import org.hibernate.Session;

import com.mille_bornes.database.HibernateUtil;
import com.mille_bornes.database.data.helper.DatabaseTable;


/**
 * Base class for database tests. Opens a session and a transaction 
 * before each test and closes them after each test.
 */
public abstract class DatabaseTestBase {

    public static String id;

    /**
     * Utility method preventing code duplication in tests.
     * Begins a transaction, persists the table, and commits the transaction.
     * Then sets the id of the table for further testing.
     * @param table The table to persist.
     */
    public static void persist(final DatabaseTable<?> table) {
        final Session session = HibernateUtil.open();
        try {
            session.beginTransaction();
            session.persist(table);
            session.getTransaction().commit();
            DatabaseTestBase.id = table.getId();
        } finally {
            session.close();
        }
    }

    public Session getSession() {
        return HibernateUtil.open();
    }

    public Session startTransaction() {
        final Session session = this.getSession();
        session.beginTransaction();
        return session;
    }

    public void endTransaction(final Session session) {
        session.getTransaction().commit();
    }
}
