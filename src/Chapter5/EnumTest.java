package Chapter5;

import java.util.Scanner;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/3
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class EnumTest {

    // 5.6 枚举类
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input = in.next().toUpperCase();

        // toString 方法会返回枚举常量名
        String small = Size.SMALL.toString();

        // toString 的逆方法是 valueOf
        Size size = null;
        try {
            size = Enum.valueOf(Size.class, input);
        } catch (Exception e) {
            System.err.println("输入类型错误");
            return;
        }

        // 返回枚举常量在 enum 声明中的位置，位置从 0 开始
        size.ordinal();

        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }

        // 全部枚举值的数组
        Size[] values = Size.values();

    }


    enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        // 枚举的构造器总是私有的
        private Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }


        private String abbreviation;
    }
}
