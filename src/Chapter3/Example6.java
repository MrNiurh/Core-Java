package Chapter3;

import javax.xml.crypto.Data;
import java.io.Console;
import java.text.DateFormat;
import java.util.Date;
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

        double x = 1000.0 / 3.0;
        System.out.println("x = " + x);
        System.out.print("printf(\"%8.3f\",x):");
        System.out.printf("%8.2f\n", x);

        /*
            用于 printf 的转换符
            转换符:d  类型:十进制整数
            转换符:x  类型:十六进制整数
            转换符:o  类型:八进制整数
            转换符:f  类型:定点浮点数
            转换符:e  类型:指数浮点数
            转换符:g  类型:通用浮点数(e 和 f 中较短的一个)
            转换符:a  类型:十六进制浮点数
            转换符:s  类型:字符串
            转换符:c  类型:字符
            转换符:b  类型:布尔
            转换符:h  类型:散列码
            转换符:%  类型:百分号
            转换符:n  类型:与平台有关的行分隔符
         */
        String username = "MrNiurh";
        int age = 22;
        System.out.printf("Hello,%s.Next year,you'll be %d", username, age + 1);
        System.out.println();
        //System.out.printf("%(,f ",-x);

        /*
            用于 printf 的标志
            标志:+  目的:打印正数和负数的符号
            标志:空格  目的:在正数之前添加空格
            标志:0  目的:数字前面补0
            标志:-  目的:左对齐
            标志:(  目的:将负数括在括号内
            标志:,  目的:添加分组分隔符
            标志:#(对于 f 格式)  目的:包含小数点
            标志:#(对于 x 或 0 格式)  目的:添加前缀 0x 或 0
            标志:$  目的:指定要格式化的参数索引
            标志:<  目的:格式化前面说明的数值
         */

        // 使用静态的 String.format 方法创建一个格式化的字符串，而不打印输出
        String message = String.format("Hello,%s.Next year,you'll be %d\n", username, age + 1);

        System.out.printf("%8.3f\n", x);        // " 333.333"       共8位(含小数点),保留3位小数
        System.out.printf("%08.3f\n", x);       // "0333.333"       数字前面补0
        System.out.printf("%-8.3f\n", x);       // "333.333"        左对齐
        System.out.printf("%(-8.3f\n", -x);     // "(333.333)"      将负数括在括号内，左对齐
        System.out.printf("%-#8.2f\n", 159f);   // "159.00 "        添加前缀，左对齐
        System.out.printf("%,d\n", 1234567890); // "1,234,567,890"  添加分组分隔符

        System.out.printf("%1$s %2$tB %2$te,%2$tY\n","Due date:",new Date());
        System.out.printf("%s %tB %<te,%<tY\n","Due date:",new Date());
    }
}
