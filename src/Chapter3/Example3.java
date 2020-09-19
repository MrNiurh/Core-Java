package Chapter3;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/18
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example3 {

    // 3.4 变量与常量
    public static void main(String[] args) {
        variableTest();
        System.out.println("=======================================");
        enumTest();
    }

    /**
     * 变量的声明测试（var）
     *
     * @return void
     */
    private static void variableTest() {
        // 从Java 10开始，对于局部变量，如果可以从变量的初始值推断出它的类型，就不需要声明类型
        var vacationDays = 12;
        Object obj = vacationDays;
        System.out.println("The Object of ' var vacationDays = 12 ' is: " + obj.getClass().toString());

        var greeting = "Hello";
        Object obj2 = greeting;
        System.out.println("The Object of ' var greeting = \"Hello\" ' is : " + obj2.getClass().toString());
    }

    enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE;
    }

    /**
     * 枚举类型测试
     *
     * @return void
     */
    private static void enumTest() {
        Size s = Size.SMALL;
        System.out.println(s);
        System.out.println("The Object of ' Size.SMALL ' is:  " + s.getClass().toString());

    }


}
