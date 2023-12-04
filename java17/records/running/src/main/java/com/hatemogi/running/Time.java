package com.hatemogi.running;

import java.time.Duration;

public class Time {
    private final Duration t;

    private Time(Duration t) {
        this.t = t;
    }

    public static Time ofSeconds(int sec) {
        return new Time(Duration.ofSeconds(sec));
    }

    public static Time of(int min, int sec) {
        return ofSeconds(min * 60 + sec);
    }

    public static Time of(int hour, int min, int sec) {
        return ofSeconds((hour * 60 + min) * 60 + sec);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Time)) return false;
        return t.equals(((Time)other).t);
    }

    @Override
    public int hashCode() {
        return t.hashCode();
    }

    Duration getDuration() {
        return t;
    }

    int getSeconds() {
        return (int)t.getSeconds();
    }

    public String toString() {
        int hour = (int)t.toHours();
        int min = (int)t.toMinutes() % 60;
        int sec = (int)t.getSeconds() % 60;
        String hourS = hour == 0 ? "" : hour + "시간";
        String minS = min == 0 ? "" : min + "분";
        String secS = sec == 0 ? "" : sec + "초";

        return String.format("(시간=%s%s%s)", hourS, minS, secS);
    }
}
