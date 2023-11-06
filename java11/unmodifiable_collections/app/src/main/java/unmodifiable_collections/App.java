package unmodifiable_collections;

import java.util.*;

import static java.util.Map.entry;

public class App {
    private void unmodifiableList() {
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

    private void unmodifiableSet() {
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

    private void unmodifiableMap() {
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
            Map<String, Integer> stringMap = Map.of("가", 1, "나", 2, "다", 3);
            System.out.println(stringMap);
        }
        /* JDK9. 10개 키값쌍이 이상인 경우 */
        {
            Map<String, Integer> stringMap = Map.ofEntries(
                    entry("가", 1),
                    entry("나", 2),
                    entry("다", 3)
            );
            System.out.println(stringMap);
        }
    }

    private void unmodifiableCollectionFromStream() {

    }
    
    public void run() {
        unmodifiableList();
        unmodifiableSet();
        unmodifiableMap();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
