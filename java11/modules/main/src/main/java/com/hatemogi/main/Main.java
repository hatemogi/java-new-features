package com.hatemogi.main;

import com.hatemogi.running.*;

public class Main {
    private static void elapsed(Pace p, Distance d) {
        Time t = Running.elapsed(p, d);
        System.out.printf("%s로 %s를 뛰면, %s 걸립니다.%n", p, d, t);
    }

    private static void targetPace(Distance d, Time t) {
        Pace p = Running.pace(d, t);
        System.out.printf("%s를 %s만에 뛰려면 %s로 뛰면 됩니다.\n", d, t, p);
    }

    public static void main(String[] args) {
        elapsed(Pace.P600, Distance.K5);
        elapsed(Pace.of(450), Distance.K10);

        targetPace(Distance.K10, Time.of(45, 0));

        Time sub2 = Time.of(1, 59, 59);
        targetPace(Distance.HALF, sub2);

        Time sub4 = Time.of(3, 59, 59);
        targetPace(Distance.FULL, sub4);

        Time sub3 = Time.of(2, 59, 59);
        targetPace(Distance.FULL, sub3);
    }
}
