package com.hatemogi.records;

import com.hatemogi.running.*;

/**
 * Java 17 LTS 기준 Records
 * https://docs.oracle.com/en/java/javase/16/language/records.html
 */

record Activity(Distance distance, Time time) {

}

public class App {

    public static void main(String[] args) {
        var activity = new Activity(Distance.K5, Time.of(30, 0));
        System.out.println(activity);
    }
}
