package com.hatemogi.localvar;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private void lambdaExpressionSince8And11() {
        Predicate<String> valid1 = (String s) -> !s.isEmpty();
        Predicate<String> valid2 = s -> !s.isEmpty();
        Predicate<String> valid3 = (var s) -> !s.isEmpty();

        Predicate<Integer> odd = (var x) -> x % 2 == 1;
        var odds = Stream.of(1, 2, 3, 4, 5)
                .filter(odd)
                .collect(Collectors.toUnmodifiableList());
        System.out.printf("홀수=%s\n", odds);
    }

    private void run() {
        previousLocalVars();
        java10LocalVars();
        localVarsSince5();
        localVarsSince7();
        lambdaExpressionSince8And11();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
