package Chapter6;

import java.util.Arrays;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/14
 * @description This program demonstrates the use of the Comparable interface
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class EmployeeSortTest {

    // 6.1.1 接口的概念
    public static void main(String[] args) {

        var staff = new Employee[3];

        staff[0] = new Employee("Tom", 35000);
        staff[1] = new Employee("Rick", 75000);
        staff[2] = new Employee("Jerry", 38000);

        Arrays.sort(staff);

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.printf("name=%s,salary=%8.2f%n", e.getName(), e.getSalary());
        }
    }

    /**
     * int compareTo(T other) 用这个对象与 other 进行比较。如果这个对象小于 other 则返回一个负整数；如果相等则返回 0；否则返回一个正整数。
     * static void sort(Object[] a) 对数组 a 中的元素进行排序。要求数组中的元素必须属于实现了 Comparable 接口的类，并且元素之间必须是可比较的。
     * static int compare(int x, int y) 如果 x < y 返回一个负整数；如果 x 和 y 相等，则返回 0；否则返回一个正整数。
     * static int compare(double x, double y) 如果 x < y 返回一个负整数；如果 x 和 y 相等则返回 0；否则返回一个正整数。
     */
}
