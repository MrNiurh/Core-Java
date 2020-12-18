package Chapter12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/18
 * @Description This program demonstrates the Callable interface and executors.
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ExecutorDemo {

    // 12.6.3 控制任务组

    /**
     * Counts occurrences of a given word in file.
     *
     * @param word
     * @param path
     * @return long
     */
    public static long occurrences(String word, Path path) {
        try (var in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count++;
            return count;
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * Returns all descendants of a given directory
     *
     * @param rootDir
     * @return java.util.Set<java.nio.file.Path>
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.filter(Files::isRegularFile).collect(Collectors.toSet());
        }
    }

    /**
     * Yields a task that searches for a word in a file.
     *
     * @param word
     * @param path
     * @return java.util.concurrent.Callable<java.nio.file.Path>
     */
    public static Callable<Path> searchForTask(String word, Path path) {
        return () -> {
            try (var in = new Scanner(path)) {
                while (in.hasNext()) {
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Search in " + path + " canceled.");
                        return null;
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. C:\\Files\\test): ");
            String start = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));
            var tasks = new ArrayList<Callable<Long>>();

            for (Path file : files) {
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            ExecutorService executor = Executors.newCachedThreadPool();
            // use a single thread executor instead to see if multiple threads
            // speed up to search
            //  ExecutorService executor = Executors.newSingleThreadExecutor()

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;

            for (Future<Long> result : results)
                total += result.get();


            Instant endTime = Instant.now();
            System.out.println("Occurrences of " + word + ": " + total);
            System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + " ms.");

            var searchTasks = new ArrayList<Callable<Path>>();

            for (Path file : files) {
                searchTasks.add(searchForTask(word, file));
            }

            Path found = executor.invokeAny(searchTasks);
            System.out.println(word + " occurs in: " + found);
            if (executor instanceof ThreadPoolExecutor) // the single thread isn't
                System.out.println("Largest pool size: " + ((ThreadPoolExecutor) executor).getLargestPoolSize());

            executor.shutdown();
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
