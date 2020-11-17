package Chapter6;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/15
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example1 {


    public static void main(String[] args) {

        //MethodReference();


        String[] strings = new String[]{"Tom", "Jerry", "morty", "rick"};

        // 对字符排序，而不考虑字母的大小写
        Arrays.sort(strings, String::compareToIgnoreCase);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * 6.2.4 方法引用
     *
     * @return void
     */
    public static void MethodReference() {
        var timer = new Timer(1000, event -> System.out.println(event));
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit timer?");
        timer.stop();

        /**
         * 表达式 System.err::println 是一个方法引用（method reference），它指示编译器生成一个函数式接口的实例，覆盖这个接口的抽象方法来
         *      调用给定的方法。
         * 在这个例子中，会生成一个 ActionListener，它的 actionPerformed(ActionEvent e)方法要调用 System.out.println(e)。
         */
        var timer2 = new Timer(1000, System.err::println);
        timer2.start();
        JOptionPane.showMessageDialog(null, "Quit timer2?");
        timer2.stop();
    }

}
