package com.hatemogi.running;

import java.time.Duration;

public class Pace {
    private Duration durationPerK;

    public Pace(int secondsPerK) {
        this.durationPerK = Duration.ofSeconds(secondsPerK);
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
        return "페이스: " + min + ":" + sec + "sec/1K";
    }
}
