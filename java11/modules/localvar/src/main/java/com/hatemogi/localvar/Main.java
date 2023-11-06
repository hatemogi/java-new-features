package com.hatemogi.localvar;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.Map.entry;

public class Main {

    private void localVarsSince5() {
        List<String> cs1 = Collections.<String>emptyList();
        List<String> cs2 = Collections.emptyList();
    }

    private void localVarsSince7() {
        Map<String, List<String>> channels1 = new HashMap<String, List<String>>();
        Map<String, List<String>> channels2 = new HashMap<>();
        var channels3 = new HashMap<String, List<String>>();
    }

    private void lambdaExpressionSince8() {
        Predicate<String> valid1 = (String s) -> !s.isEmpty();
        Predicate<String> valid2 = s -> !s.isEmpty();
    }

    private void previousLocalVars() {
        List<String> cities = List.of("서울", "제주");
        Map<String, Integer> citiesPopulation
                = Map.ofEntries(
                        entry("서울", 9_409_466), entry("제주", 676_489));
        System.out.println(citiesPopulation);
    }

    private void java10LocalVars() {
        var cities = List.of("서울", "제주");
        var citiesPopulation
                = Map.ofEntries(
                        entry("서울", 9_409_466), entry("제주", 676_489));
        System.out.println(citiesPopulation);
    }

    private void run() {
        previousLocalVars();
        java10LocalVars();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
