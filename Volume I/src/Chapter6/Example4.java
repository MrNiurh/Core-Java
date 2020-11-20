package Chapter6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/20
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example4 {

    // 6.2.8 再谈 Comparator
    public static void main(String[] args) {

        Employee[] people = new Employee[4];

        // 按名字进行排序
        Arrays.sort(people, Comparator.comparing(Employee::getName));

        // 如果姓名相同就会按照第二个比较器
        Arrays.sort(people, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));

        // 按照人名长度完成排序
        Arrays.sort(people, Comparator.comparing(Employee::getName, (s, t) -> Integer.compare(s.length(), t.length())));

        // 前一种操作，更容易的方法
        Arrays.sort(people, Comparator.comparingInt(p -> p.getName().length()));


    }
}
