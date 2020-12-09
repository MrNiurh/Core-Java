package Chapter9;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/9
 * @description This program demonstrates the use of a priority queue.
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class PriorityQueueTest {

    // 9.3.6 优先队列
    public static void main(String[] args) {

        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1901, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements . . .");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements . . .");

        /**
         * 无论何时调用 remove 方法，总会获得当前优先队列中最小的元素
         */
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
