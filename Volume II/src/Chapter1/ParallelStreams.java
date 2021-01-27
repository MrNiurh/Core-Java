package Chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/01/27
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ParallelStreams {

    // 1.14 并行流
    public static void main(String[] args) throws IOException {

        var contents = new String(Files.readAllBytes(
                Paths.get("Volume II", "src", "Resources", "txt", "paper.txt")), StandardCharsets.UTF_8);
        List<String> wordList = List.of(contents.split("\\PL+"));

        // very bad code ahead
        var shortWords = new int[10];
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) shortWords[s.length()]++;
        });

        System.out.println(Arrays.toString(shortWords));

        // Try again--the result will likely be different (and also wrong)
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        // Remedy:Group and count
        Map<Integer, Long> shortWordCounts = wordList.parallelStream().filter(s -> s.length() < 10)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(shortWordCounts);

        // DownStream order not deterministic
        Map<Integer, List<String>> result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length)
        );
        System.out.println(result.get(12));

        // 不保留重复
        Map<Integer, Set<String>> result2 = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length, Collectors.mapping(String::valueOf, Collectors.toSet()))
        );
        System.out.println(result2.get(12));

        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length, Collectors.counting())
        );

        System.out.println(wordCounts);
    }
}
