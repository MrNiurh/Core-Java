package Chapter3;

import static java.lang.Math.*;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/19
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example4 {


    // 3.5 运算符
    public static void main(String[] args) {

        operatorTest();
    }

    /**
     * 运算符的相关测试
     *
     * @return void
     */
    private static void operatorTest() {

        System.out.println("The result of (15 / 2) is: " + 15 / 2);// 整数除法
        System.out.println("The result of (15.0 / 2) is: " + 15.0 / 2);// 浮点数除法

        // 浮点数被 0 除会得到无穷大或 NaN 的结果
        System.out.println("The result of (10.0 / 0) is:" + 10.0 / 0);
        // 整数被 0 除将会产生一个异常
        //System.out.println("The result of (10 / 0)" + 10 / 0);

        double x = 4;
        double y = Math.sqrt(x);

        /*
           在源文件的顶部加上 import static java.lang.Math.*;
           就可以不必在数学方法名和常量名前添加前缀“Math”
         */
        System.out.println("The square root of \u03C0 is: " + sqrt(PI));
        System.out.println("The result of (1000000000 * 3) is: " + 1000000000 * 3);// 10 亿乘以 3
        // Math 的 multiplyExact() 方法会生成一个异常
        // System.out.println(multiplyExact(1000000000, 3));

        /*
            当用一个二元运算符连接两个值时（例如 n + f,n 是整数，f 是浮点数），先要将两个操作数转换为同一个类型，然后再进行运算。
            - 如果两个操作数中有一个是 double 类型，；另一个操作数就会转换为 double 类型。
            - 否则，如果其中一个操作数是 float 类型，另一个操作数就会转换为 float 类型。
            - 否则，如果其中一个操作数是 long 类型，另一个操作数就会转换为 long 类型。
            - 否则，两个操作数都转换为 int 类型。
         */

        /*
            当调用 round 的时候，仍然需要使用强制类型转换（int）。其原因是 round 方法返回的结果为 long 型，
            由于存在信息丢失的可能性，所以只有使用显示的强制类型转换才能够将 long 类型转换成 int 类型。
         */
        x = 9.997;
        int nx = (int) Math.round(x);

        // 如果运算符得到一个值，其类型与左侧操作数的类型不同，就会发生强制类型转换。
        int n = 4;
        System.out.println("The result of (n += 3.5) is(int n = " + n + "): " + (n += 3.5));

        // 返回 x 和 y 中较小的一个
        // x = 9.997; y = 2.0;
        System.out.println((x < y ? x : y));

        // 移位运算符的右操作数要完成模 32 的运算（除非左操作数是 long 类型，在这种情况下需要对右操作数模 64）
        System.out.println("The result of (1 << 35) is: " + (1 << 35) + ",and the result of (1 << 3) is: " + (1 << 3));

        /*
            因为 += 是右结合运算，所以表达式 a += b += c 等价于
            a += (b += c)
         */

        /*
            位运算符包括： & ("and")  | ("or")  ^ ("xor")  ~("not")
         */
    }
}
