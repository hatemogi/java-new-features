package com.hatemogi.running;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunningTest {

    @Test
    public void testCalculations() {
        Distance d = Running.distance(Pace.of(600), Time.of(60, 0));
        assertEquals(Distance.ofKM(10), d);

        Time t = Running.elapsed(Pace.of(530), Distance.ofKM(10));
        assertEquals(Time.of(55, 0), t);

        Pace p = Running.pace(Distance.ofKM(10), Time.of(60, 0));
        assertEquals(p, Pace.of(600));
    }
}
