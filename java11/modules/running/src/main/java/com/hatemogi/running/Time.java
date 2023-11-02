package com.hatemogi.running;

import java.time.Duration;

public class Time {
    private Duration t;

    private Time(Duration t) {
        this.t = t;
    }

    public static Time ofSeconds(int sec) {
        return new Time(Duration.ofSeconds(sec));
    }

    public static Time of(int min, int sec) {
        return ofSeconds(min * 60 + sec);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Time otherTime)) return false;
        return this.t.equals(otherTime.t);
    }

    @Override
    public int hashCode() {
        return t.hashCode();
    }

    Duration getDuration() {
        return t;
    }

    public String toString() {
        int sec = (int)t.getSeconds();
        int min = sec / 60;
        return String.format("(시간=%d분%02d초)", min, sec % 60);
    }
}
