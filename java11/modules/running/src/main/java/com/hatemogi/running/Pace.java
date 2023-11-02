package com.hatemogi.running;

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

    public static final Pace P400 = Pace.of(400);
    public static final Pace P430 = Pace.of(430);
    public static final Pace P500 = Pace.of(500);
    public static final Pace P530 = Pace.of(530);
    public static final Pace P600 = Pace.of(600);
    public static final Pace P630 = Pace.of(630);
    public static final Pace P700 = Pace.of(700);
    public static final Pace P730 = Pace.of(730);

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pace)) return false;
        return this.durationPerK.equals(((Pace)other).durationPerK);
    }

    @Override
    public int hashCode() {
        return durationPerK.hashCode();
    }

    public String toString() {
        long min = durationPerK.toMinutes();
        long sec = durationPerK.toSecondsPart();
        return (sec == 0)
                ? String.format("(페이스=%d분/K)", min)
                : String.format("(페이스=%d분%02d초/K)", min, sec);
    }

    /** 시속으로 환산 */
    public double toKPH() {
        return 3600.0 / durationPerK.getSeconds();
    }

    int getSPK() {
        return (int)durationPerK.getSeconds();
    }
}
