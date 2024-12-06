package com.mille_bornes.utils;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;


public class RandomUtilTest {

    @Test
    public static void testUuid() {
        final String uuid1 = RandomUtil.uuid();
        final String uuid2 = RandomUtil.uuid();
        assertNotEquals(uuid1, uuid2);
    }
}
