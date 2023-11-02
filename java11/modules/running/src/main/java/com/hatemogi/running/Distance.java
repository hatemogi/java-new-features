package com.hatemogi.running;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class Distance implements Comparable<Distance> {
    private int meters;
    private static NumberFormat formatter;

    private Distance(int meters) {
        this.meters = meters;
        formatter = DecimalFormat.getInstance();
        formatter.setMinimumFractionDigits(0);
        formatter.setMaximumFractionDigits(3);
    }

    public static Distance ofMeter(int meters) {
        return new Distance(meters);
    }

    public static Distance ofKM(int killometers) {
        return Distance.ofMeter(killometers * 1000);
    }

    public final static Distance K5 = Distance.ofKM(5);
    public final static Distance K10 = Distance.ofKM(10);
    public final static Distance K20 = Distance.ofKM(20);
    public final static Distance HALF = Distance.ofMeter(21098);
    public final static Distance FULL = Distance.ofMeter(42195);

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
        return String.format("(거리=%sKM)", formatter.format(meters / 1000.0));
    }

    @Override
    public int compareTo(Distance other) {
        return Integer.compare(meters, other.meters);
    }

    int getMeters() {
        return meters;
    }
}
