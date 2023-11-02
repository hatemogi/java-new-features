package com.hatemogi.running;

import java.security.Key;
import java.time.Duration;

public final class Pace {
    private Duration durationPerK;

    private Pace(int secondsPerK) {
        this.durationPerK = Duration.ofSeconds(secondsPerK);
    }

    public static Pace ofSecPerK(int spk) {
        return new Pace(spk);
    }

    public static Pace ofMinAndSecPerK(int min, int sec) {
        return new Pace(min * 60 + sec);
    }

    public static Pace of(int pace) {
        return ofMinAndSecPerK(pace / 100, pace % 100);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pace otherPace)) return false;
        return this.durationPerK.equals(otherPace.durationPerK);
    }

    @Override
    public int hashCode() {
        return durationPerK.hashCode();
    }

    public String toString() {
        long min = durationPerK.toMinutes();
        long sec = durationPerK.toSecondsPart();
        return String.format("(페이스=%d분%02d초/K)", min, sec);
    }

    /** 시속으로 환산 */
    public double toKPH() {
        return 3600.0 / durationPerK.getSeconds();
    }

    int getSPK() {
        return (int)durationPerK.getSeconds();
    }
}
