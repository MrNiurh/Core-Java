package Chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/15
 * @description 定时器与动作监听器的具体使用
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class TimerTest {

    // 6.1.7 接口与回调
    public static void main(String[] args) {

        var listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every second
        var timer = new Timer(1000, listener);
        // 开始
        // 一旦 main 方法退出，程序就中止
        timer.start();

        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        // 结束
        // timer.stop();
        System.exit(0);

    }

    static class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * javax.swing.JOptionPane
     *
     * static void showMessageDialog(Component parent, Object message) 显示一个包含一条提示消息和 OK 按钮的对话框，这个对话框位于
     *      Parent 组件中央，如果 parent 为 null，对话框将显示在屏幕中央。
     */

    /**
     * javax.swing.Timer
     *
     * Timer(int interval, ActionListener listener) 构造一个定时器，每经过 interval 毫秒通知 listener 一次。
     * void start() 启动定时器。一旦启动，定时器将调用监听器的 actionPerformed。
     * void stop() 停止定时器。一旦停止，定时器将不再调用监听器的 actionPerformed。
     */

    /**
     * static Toolkit getDefaultToolkit() 获得默认的工具箱。工具箱包含有关 GUI 环境的信息。
     * void beep() 发出一声铃响。
     */
}
