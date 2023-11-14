package text_blocks;

import java.util.List;

/**
 * Java 17 LTS 기준 Text Blocks
 * https://docs.oracle.com/en/java/javase/15/text-blocks/index.html
 */
public class App {

    static void printTextString1() {
        String hoonmin = "나라의 말이 중국과 달라\n" +
                "문자와 서로 통하지 아니하기에,\n" +
                "이런 까닭으로 어리석은 백성이 말하고자 할 바가 있어도\n" +
                "마침내 제 뜻을 능히 펴지 못하는 사람이 많다.\n";
        System.out.println(hoonmin);
    }

    static void printTextString2() {
        String hoonmin = new StringBuffer()
            .append("나라의 말이 중국과 달라\n")
            .append("문자와 서로 통하지 아니하기에,\n")
            .append("이런 까닭으로 어리석은 백성이 말하고자 할 바가 있어도\n")
            .append("마침내 제 뜻을 능히 펴지 못하는 사람이 많다.\n")
            .toString();
        System.out.println(hoonmin);
    }

    static void printTextString3() {
        String hoonmin = String.join("\n",
            List.of("나라의 말이 중국과 달라",
                "문자와 서로 통하지 아니하기에,",
                "이런 까닭으로 어리석은 백성이 말하고자 할 바가 있어도",
                "마침내 제 뜻을 능히 펴지 못하는 사람이 많다.",
                "")
        );
        System.out.println(hoonmin);
    }

    static void printTextBlock() {
        String hoonmin = """
            나라의 말이 중국과 달라
            문자와 서로 통하지 아니하기에,
            이런 까닭으로 어리석은 백성이 말하고자 할 바가 있어도
            마침내 제 뜻을 능히 펴지 못하는 사람이 많다.
            """;
        System.out.println(hoonmin);
    }

    static void indentedTextBlock() {
        String indented = """
            나라의 말이 중국과 달라
            문자와 서로 통하지 아니하기에,
            이런 까닭으로 어리석은 백성이 말하고자 할 바가 있어도
            마침내 제 뜻을 능히 펴지 못하는 사람이 많다.
            """.indent(4);
        System.out.println(indented);
    }

    public static void main(String[] args) {
        printTextString1();
        printTextString2();
        printTextString3();
        printTextBlock();
        indentedTextBlock();
    }
}
