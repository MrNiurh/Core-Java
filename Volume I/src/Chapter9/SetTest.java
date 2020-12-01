package Chapter9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/1
 * @description This program uses a set to print all unique words in System.in
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class SetTest {

    // 9.3.3 散列集
    public static void main(String[] args) {

        var words = new HashSet<String>();
        long totalTime = 0;
        int count = 0;

        try (var in = new Scanner(System.in)) {
            while (in.hasNext() && count < 10) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
                count++;
            }
        }

        Iterator<String> iter = words.iterator();

        for (int i = 0; i < 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println(". . .");
        System.out.println(words.size() + " distinct word. " + totalTime + " ms. ");
    }
}
