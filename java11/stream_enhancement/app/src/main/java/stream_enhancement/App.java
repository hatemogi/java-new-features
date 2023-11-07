/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package stream_enhancement;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 11 LTS 기준 Stream 개선사항
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
 */
public class App {
    void ofNullable() {
        Stream<String> s1 = Stream.ofNullable(null);
        var s2 = Stream.of("가", "나", "다");
        var ss = Stream.concat(s1, s2).collect(Collectors.toUnmodifiableList());
        System.out.println("Stream.ofNullable(null) ++ Stream.of(가, 나, 다) = " + ss);
    }

    void takeWhile() {
        var nats = Stream.iterate(1, (var n) -> n + 1);
        var under5 = nats.takeWhile((var n) -> n < 5).collect(Collectors.toUnmodifiableList());
        System.out.println("nats.takeWhile(..) => " + under5);
    }

    void dropWhile() {
        var nats = Stream.iterate(1, (var n) -> n + 1);
        var from5under10 = nats
                .dropWhile((var n) -> n < 5)
                .takeWhile((var n) -> n < 10)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("nats.dropWhile(..).takeWhile(..) => " + from5under10);
    }

    void run() {
        ofNullable();
        takeWhile();
        dropWhile();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
