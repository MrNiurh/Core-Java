package Chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/16
 * @description This program demonstrates the use of inner classes.
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class InnerClassTest {

    // 6.3.1 使用内部类访问对象状态
    public static void main(String[] args) {

        var clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    /**
     * A clock that prints the time in regular intervals.
     */
    static class TalkingClock {

        private int interval;
        private boolean beep;

        /**
         * Constructs a talking clock
         *
         * @param interval the interval between messages (in milliseconds)
         * @param beep     true if the clock should beep
         */
        public TalkingClock(int interval, boolean beep) {
            this.interval = interval;
            this.beep = beep;
        }

        /**
         * Starts the clock
         */
        public void start() {
            var listener = new TimePrinter();
            var timer = new Timer(interval, listener);
            timer.start();
        }

        /**
         * 可以把 TimePrinter 类声明为私有（private）。这样一来，只有 TalkingClock 方法才能够构造 TimePrinter 对象。
         * 只有内部类可以是私有的，而常规类可以有包可见性或公共可见性。
         */
        public class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone,the time is " + Instant.ofEpochMilli(event.getWhen()));

                /**
                 * TimePrinter 类没有实例字段或者名为 beep 的变量，实际上，beep 指示 TalkingClock 对象中创建这个 TimePrinter 的字段。
                 */
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
    }
}
