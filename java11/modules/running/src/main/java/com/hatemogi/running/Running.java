package com.hatemogi.running;

import java.time.Duration;

public final class Running {
    public static Time elapsed(Pace p, Distance d) {
        int spk = p.getSPK();
        int sec = d.getMeters() * spk / 1000;
        return Time.ofSeconds(sec);
    }

    public static Distance distance(Pace p, Duration t) {
        int spk = p.getSPK();
        int sec = (int)t.getSeconds();
        return Distance.ofMeter(sec * 1000 / spk );
    }

    public static Pace pace(Distance d, Duration t) {
        int meters = d.getMeters();
        return Pace.ofSecPerK((int)t.getSeconds() * 1000 / meters);
    }
}
