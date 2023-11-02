package com.hatemogi.running;

public final class Distance implements Comparable<Distance> {
    private int meters;

    private Distance(int meters) {
        this.meters = meters;
    }

    public static Distance ofMeter(int meters) {
        return new Distance(meters);
    }

    public static Distance ofKM(int killometers) {
        return Distance.ofMeter(killometers * 1000);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(meters);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Distance)) return false;
        return meters == ((Distance) other).meters;
    }

    public String toString() {
        return String.format("(거리=%.2fKM)", meters / 1000.0);
    }

    @Override
    public int compareTo(Distance other) {
        return Integer.compare(meters, other.meters);
    }

    int getMeters() {
        return meters;
    }
}
