package Chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/1/24
 * @Description 基本类型流
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class PrimitiveTypeStreams {

    // 1.1.3 基本类型流
    public static void show(String title, IntStream stream) {

        final int SIZE = 10;
        // 限定长度
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.println(title + ": ");

        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements[i]);
            else System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        // 随机数
        IntStream is1 = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1", is1);
        // 不含末尾
        IntStream is2 = IntStream.range(5, 10);
        show("is2", is2);
        // 含末尾
        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3", is3);

        Path path = Paths.get("Volume II", "src", "Resources", "txt", "paper.txt");
        var contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        // 单词长度
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        IntStream is4 = words.mapToInt(String::length);
        show("is4", is4);
        var sentence = "\uD835\uDD46 is the set of octonions.";
        System.out.println(sentence);

        IntStream codes = sentence.codePoints();
        System.out.println(codes.mapToObj(c -> String.format("%X", c)).collect(
                Collectors.joining()));

        // 递增
        Stream<Integer> integers = IntStream.range(0, 100).boxed();
        IntStream is5 = integers.mapToInt(Integer::intValue);
        show("is5", is5);

    }
}
