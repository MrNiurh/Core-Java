package Chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/19
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class CountLongWords {

    // 1.1 从迭代到流的操作
    public static void main(String[] args) throws IOException {

        // 单词长度（大于此长度则计数）
        int wordLength = 12;

        var contents = new String(Files.readAllBytes(
                Paths.get("E:/IdeaProjects/Core-Java/Volume II/src/Resources/txt/paper.txt")
        ), StandardCharsets.UTF_8);

        // 以非字母分隔符
        List<String> words = List.of(contents.split("\\PL+"));

        long startTime = System.currentTimeMillis();

        long count = 0;
        for (String w : words) {
            if (w.length() > wordLength) count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("count:%d, %s ms.\n", count, (endTime - startTime));

        startTime = System.currentTimeMillis();
        count = words.stream().filter(w -> w.length() > wordLength).count();
        endTime = System.currentTimeMillis();
        System.out.printf("count:%d, %s ms.\n", count, (endTime - startTime));

        startTime = System.currentTimeMillis();
        count = words.parallelStream().filter(w -> w.length() > wordLength).count();
        endTime = System.currentTimeMillis();
        System.out.printf("count:%d, %s ms.\n", count, (endTime - startTime));
    }
}
