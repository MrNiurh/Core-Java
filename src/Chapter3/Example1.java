package Chapter3;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/6
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example1 {

    public static void main(String[] args) {
        nanTest();
        doubleTest();

    }

    /**
     * 用于检测一个特定值是否为 NaN用于检测一个特定值是否为 NaN
     *
     * @return void
     */
    private static void nanTest() {
        double num = Double.NaN;

        if (num == Double.NaN) {
            System.out.println("num == Double.NaN: I can test it correctly");
        } else {
            System.out.println("num == Double.NaN: I can not test it correctly");
        }

        if (Double.isNaN(num)) {
            System.out.println("Double.isNaN(num): I can test it correctly");
        } else {
            System.out.println("Double.isNaN(num): I can not test it correctly");
        }

        System.out.println("=======================================");
    }

    /**
     * 浮点数值不适用于无法接受舍入误差的计算, 计算 （2.0 - 1.1） 的值
     *
     * @return void
     */
    private static void doubleTest() {
        System.out.println("Result of 2.0 - 1.1 is: " + (2.0 - 1.1));
    }

}



