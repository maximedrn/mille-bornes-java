package com.mille_bornes.database;

import org.junit.jupiter.api.Test;


public class HibernateUtilTest {

    @Test
    public void testConnection() {
        HibernateUtil.open();
        System.out.println("Session opened.");
        HibernateUtil.close();
        System.out.println("Session closed.");
    }
}
