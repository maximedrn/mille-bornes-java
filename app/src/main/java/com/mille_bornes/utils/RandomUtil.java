package com.mille_bornes.utils;

import java.util.UUID;


/**
 * Utility class for random operations.
 */
public class RandomUtil {

    /**
     * Generates a random UUID.
     * @return a random UUID.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
