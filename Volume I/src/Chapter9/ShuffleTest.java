package Chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/12
 * @description This program demonstrates the random shuffle and sort algorithms.
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ShuffleTest {

    // 9.6.2 排序与混排
    public static void main(String[] args) {

        var numbers = new ArrayList<Integer>();

        for (int i = 0; i < 49; i++) {
            numbers.add(i);
        }

        // 打乱顺序
        Collections.shuffle(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);

        System.out.println(winningCombination);
    }
}
