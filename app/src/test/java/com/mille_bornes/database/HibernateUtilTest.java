package com.mille_bornes.database;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;


public class HibernateUtilTest {

    @Test
    public void testConnection() {
        final Session session = HibernateUtil.open();
        System.out.println("Session opened.");
        session.close();
        System.out.println("Session closed.");
    }
}
