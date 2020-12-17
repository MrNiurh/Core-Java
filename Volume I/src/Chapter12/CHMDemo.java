package Chapter12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/17
 * @Description This program demonstrates concurrent hash maps.
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class CHMDemo {

    // 12.5.3 映射条目的原子更新
    public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    /**
     * Adds all words in the given file to the current hash map.
     *
     * @param file
     * @return void
     */
    public static void process(Path file) {
        try (var in = new Scanner(file)) {
            while (in.hasNext()) {
                String word = in.next();
                map.merge(word, 1L, Long::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all descendants of a given directory
     *
     * @param rootDir the root directory
     * @return java.util.Set<java.nio.file.Path>
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.collect(Collectors.toSet());
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);
        Path pathToRoot = Path.of(".");
        for (Path p : descendants(pathToRoot)) {
            if (p.getFileName().toString().endsWith(".java"))
                executor.execute(() -> process(p));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);

        map.forEach((k, v) -> {
            if (v >= 10)
                System.out.println(k + " occurs " + v + " times");
        });
    }

}
