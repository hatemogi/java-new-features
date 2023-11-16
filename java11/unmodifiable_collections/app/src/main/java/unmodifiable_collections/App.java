package unmodifiable_collections;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class App {
    void unmodifiableList() {
        /* JDK8 */
        {
            List<String> stringList = Arrays.asList("가", "나", "다");
            stringList = Collections.unmodifiableList(stringList);
        }
        /* JDK9 */
        {
            List<String> stringList = List.of("가", "나", "다");
        }
    }

    void unmodifiableSet() {
        /* JDK8 */
        {
            Set<String> stringSet = new HashSet<>(Arrays.asList("가", "나", "다"));
            stringSet = Collections.unmodifiableSet(stringSet);
        }
        /* JDK9 */
        {
            Set<String> stringSet = Set.of("가", "나", "다");
        }
    }

    void unmodifiableMap() {
        /* JDK8 */
        {
            Map<String, Integer> stringMap = new HashMap<>();
            stringMap.put("가", 1);
            stringMap.put("나", 2);
            stringMap.put("다", 3);
            stringMap = Collections.unmodifiableMap(stringMap);
            System.out.println(stringMap);
        }
        /* JDK9 */
        {
            var stringMap = Map.of("가", 1, "나", 2, "다", 3);
            System.out.println(stringMap);
        }
        /* JDK9. 10개 키값쌍이 이상인 경우 */
        {
            var stringMap = Map.ofEntries(
                    entry("가", 1),
                    entry("나", 2),
                    entry("다", 3)
            );
            System.out.println(stringMap);
        }
    }

    Stream<Integer> range(int endInclusive) {
        return IntStream.rangeClosed(1, endInclusive).boxed();
    }

    void unmodifiableCollectionFromStream() {
        Predicate<Integer> isEven = (var n) -> n % 2 == 0;
        Predicate<Integer> isOdd = (var n) -> n % 2 == 1;

        /* toUnmodifiableList */ {
            var evenList = range(10)
                    .filter(isEven)
                    .collect(Collectors.toUnmodifiableList());
            System.out.println(evenList); // 2, 4, 6, 8, 10
        }

        /* toUnmodifiableSet */ {
            var oddStream = range(9).filter(isOdd); // 1, 3, 5, 7, 9
            var tripleStream = range(9).filter((var n) -> n % 3 == 0); // 3, 6, 9
            var oddAndTriples = Stream.concat(oddStream, tripleStream)
                    .collect(Collectors.toUnmodifiableSet()); // 1, 3, 5, 6, 7, 9
            System.out.println(oddAndTriples);
        }

        /* toUnmodifiableMap */ {
            Function<Integer, Integer> doubler = (var n) -> n * 2;
            var collector = Collectors.toUnmodifiableMap(Function.identity(), doubler);
            var doubles = range(3).collect(collector);
            System.out.println(doubles);
        }
    }

    void collectionCopyOf() {
        var evenStream = range(9).filter((var n) -> n % 2 == 0); // 2, 4, 6, 8
        var tripleStream = range(9).filter((var n) -> n % 3 == 0); // 3, 6, 9
        var evenAndTripleList = Stream.concat(evenStream, tripleStream)
                .collect(Collectors.toUnmodifiableList()); // 2, 4, 6, 8, 3, 6, 9
        var evenAndTripleSet = Set.copyOf(evenAndTripleList); // 2, 3, 4, 6, 8, 9
        System.out.println(evenAndTripleList);
        System.out.println(evenAndTripleSet);
    }

    void run() {
        unmodifiableList();
        unmodifiableSet();
        unmodifiableMap();
        unmodifiableCollectionFromStream();
        collectionCopyOf();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
