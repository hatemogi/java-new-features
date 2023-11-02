package com.hatemogi.running;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaceTest {
    @Test
    public void testEquals() {
        Pace p = Pace.of(600);
        assertEquals(p, Pace.ofMinAndSecPerK(6, 0));
        assertEquals(p, Pace.ofSecPerK(360));
        assertEquals(p, Pace.P600);
        assertNotEquals(p, Pace.of(601));
    }

    @Test
    public void testConversion() {
        Pace p = Pace.of(600);
        assertEquals(10.0, p.toKPH());
        assertEquals(12.0, Pace.P500.toKPH());
    }
}
