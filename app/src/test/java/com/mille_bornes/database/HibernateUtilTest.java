package com.mille_bornes.database;

import org.hibernate.HibernateException;
import org.junit.jupiter.api.Test;


public class HibernateUtilTest {

    @Test
    public void testOpen() {
        try {
            HibernateUtil.open();
            System.out.println("Session opened.");
        } catch (final HibernateException exception) {
            final String message = exception.getMessage();
            System.err.println("Failed to open session: " + message);
        }
    }

    @Test
    public void testClose() {
        try {
            HibernateUtil.close();
            System.out.println("Session closed.");
        } catch (final HibernateException exception) {
            final String message = exception.getMessage();
            System.err.println("Failed to close session: " + message);
        }
    }
}
