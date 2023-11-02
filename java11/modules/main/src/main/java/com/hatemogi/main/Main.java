package com.hatemogi.main;

import com.hatemogi.running.*;

public class Main {
    public static void main(String[] args) {
        Pace p = Pace.of(600);
        Distance d = Distance.ofKM(5);
        Time t = Running.elapsed(p, d);

        System.out.printf("%s로 %s만큼 뛰면, %s가 걸립니다.%n", p, d, t);
    }
}
