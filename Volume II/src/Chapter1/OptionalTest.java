package Chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/21
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class OptionalTest {

    // 1.7 Optional 类型
    public static void main(String[] args) throws IOException {

        var contents = new String(Files.readAllBytes(
                Paths.get("Volume II", "src", "Resources", "txt", "paper.txt")
        ), StandardCharsets.UTF_8);
        List<String> wordList = List.of(contents.split("\\PL+"));

        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);

        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        optionalValue = wordList.stream()
                .filter(s -> s.contains("red"))
                .findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains red"));

        var results = new HashSet<String>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> results2 = Optional.of(-4.0)
                .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(results2);

    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


}
