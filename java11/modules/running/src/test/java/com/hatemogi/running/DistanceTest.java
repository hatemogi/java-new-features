package com.hatemogi.running;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    public void testConversion() {
        assertEquals(3000, Distance.ofKM(3).getMeters());
    }

    @Test
    public void testEquality() {
        Distance d1 = Distance.ofMeter(5000);
        assertEquals(d1, Distance.ofKM(5));
        assertEquals(d1, Distance.K5);
        assertNotEquals(d1, Distance.ofMeter(5001));
    }

    @Test
    public void testComparable() {
        var d5 = Distance.ofKM(5);
        var d10 = Distance.ofKM(10);
        var d20 = Distance.ofKM(20);
        List<Distance> xs = List.of(d10, d5, d20);
        assertEquals(List.of(d5, d10, d20), xs.stream().sorted().toList());
    }
}
