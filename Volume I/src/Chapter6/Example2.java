package Chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/18
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example2 {

    // 6.2.6 变量作用域
    public static void main(String[] args) {

        repeatMessage("Help!", 1000);
        JOptionPane.showMessageDialog(null, "Help me!");
        System.exit(0);
    }

    public static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> {
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay, listener).start();
    }

    public static void countDown(int start, int delay) {
        ActionListener listener = event -> {
            /**
             * 在 lambda 表达式中，只能引用值不会改变的变量
             */
            //start--;
            System.out.println(start);
        };
        new Timer(delay, listener).start();
    }

    public static void repeat(String text, int count) {

        for (int i = 0; i < count; i++) {
            ActionListener listener = event -> {
                /**
                 * 如果在 lambda 表达式中引用一个变量，而这个变量可能在外部改变，这也是不合法的
                 */
                //System.out.println(i + ":" + text);
                // ERROR: Cannot refer to changing i
            };
            new Timer(1000, listener).start();
        }
    }
}
