package com.hatemogi.running;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {
    @Test
    public void testEquality() {
        Time t1 = Time.ofSeconds(300);
        Time t2 = Time.of(5, 0);
        assertEquals(t1, t2);
    }
}
