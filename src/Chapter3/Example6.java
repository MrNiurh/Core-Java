package Chapter3;

import java.io.Console;
import java.util.Scanner;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/22
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example6 {

    // 3.7 输入与输出
    public static void main(String[] args) {
        ioTest();
    }

    /**
     * 输入与输出的测试
     *
     * @return void
     */
    private static void ioTest() {

        // 控制台输入
        /*Scanner sc = new Scanner(System.in);
        System.out.print("What's your name?");
        String name = sc.nextLine();
        System.out.println("Hello " + name + "!");*/


        // Java.io.Console 只能用在标准输入、输出流未被重定向的原始控制台中使用，在 Eclipse 或者其他 IDE 的控制台是用不了的。
        Console cons = System.console();

        if (cons != null) {
            String username = cons.readLine("User name: ");
            char[] password = cons.readPassword("Password:");
        } else {
            System.out.println("Console is null!");
        }

    }
}
