package Chapter3;


import java.util.Scanner;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/19
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example5 {

    // 3.6 字符串
    public static void main(String[] args) {
        stringTest();
    }

    /**
     * 字符串的用法测试
     *
     * @return void
     */
    private static void stringTest() {

        String greeting = "hello";
        String s = greeting.substring(0, 4);
        System.out.println(s);

        // 在Java 11 中，提供了 repeat 方法
        System.out.println("repeat method(Java 11): " + s.repeat(3));
        // 如果需要把多个字符串放在一起，用一个界定符分隔，，可以使用静态 join 方法
        String all = String.join(" / ", "S", "M", "L", "XL");
        System.out.println("join method: " + all);

        /*
            String 类没有提供修改字符串中某个字符的方法。
            不可变字符串有一个优点：编译器可以让字符串共享。
            Java 字符串大致类似于 char* 指针。
         */

        // 可以使用 equals 方法检测两个字符串是否相等
        greeting.equals("hello");

        /*
            如果虚拟机始终将相同的字符串共享，就可以使用 == 运算符检测是否相等。
            但实际上只有字符串字面量是共享的，而 + 或 substring 等操作得到的字符串并不共享。
            因此，千万不要使用 == 运算符测试字符串的相等性，以免在程序中出现 bug，这种 bug 就像随机产生的间歇性错误。
         */

        /*
            有时要检查一个字符串既不是 null 也不是空串，这种情况需要使用以下条件：
            if (str != null && str.length() != 0)
            首先要检查 str 不为 null，如果在一个 null 值上调用方法，会出现错误。
         */

        // 如果需要用许多小段的字符串来构建一个字符串，应当用以下步骤来创建：
        StringBuilder builder = new StringBuilder();
        builder.append(greeting);
        builder.append(all);
        System.out.println(builder.toString());


    }
}
