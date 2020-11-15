package Chapter6;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/15
 * @description This program demonstrates the use of lambda expressions.
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class LambdaTest {

    // 6.2.2 lambda 表达式的语法
    public static void main(String[] args) {

        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");

        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        // 效果相同
        // Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));

        timer.start();

        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program");
        timer.stop();
    }
}
