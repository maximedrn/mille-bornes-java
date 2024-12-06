package com.mille_bornes.database.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.mille_bornes.database.HibernateUtil;


/**
 * Base class for database tests. Opens a session and a transaction 
 * before each test and closes them after each test.
 */
public class DatabaseTestBase {

    private Session session;
    private Transaction transaction;

    /**
     * Opens a session and a transaction before each test.
     */
    @BeforeEach
    public void beforeEach() {
        this.session = HibernateUtil.open();
        this.transaction = this.session.beginTransaction();
    }

    /**
     * Closes the session and the transaction after each test.
     */
    @AfterEach
    public void afterEach() {
        this.transaction.commit();
        this.session.close();
    }

    public Session getSession() {
        return this.session;
    }
}
