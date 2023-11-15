package try_enhancement;

import java.io.*;
import java.util.function.Consumer;

public class Main {

    static Consumer<String> lineWriter(BufferedWriter writer) {
        return (String line) -> {
            try {
                writer.write(line);
                writer.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    static void plainResource() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("build.gradle.kts"));
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter("build.gradle.copied.kts"));
            try {
                w.write("// 처음 5줄을 복사합니다.\n\n");
                r.lines().limit(5).forEach(lineWriter(w));
            } finally {
                w.close();
            }
        } finally {
            r.close();
        }
    }
    
    static void previousTryResource() throws IOException {
        try (
                BufferedReader r = new BufferedReader(new FileReader("build.gradle.kts"));
                BufferedWriter w = new BufferedWriter(new FileWriter("build.gradle.copied.kts"))) {
            w.write("// 처음 5줄을 복사합니다.\n\n");
            r.lines().limit(5).forEach(lineWriter(w));
        }
    }

    static void enhancedTryResource() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("build.gradle.kts"));
        BufferedWriter w = new BufferedWriter(new FileWriter("build.gradle.copied.kts"));
        try (r; w) {
            w.write("// 처음 5줄을 복사합니다.\n\n");
            r.lines().limit(5).forEach(lineWriter(w));
        }
    }

    public static void main(String[] args) throws IOException {
        previousTryResource();
        enhancedTryResource();
    }
}
