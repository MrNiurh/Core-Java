package Chapter3;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/6
 * @github https://github.com/MrNiurh
 **/
public class Example1 {

    public static void main(String[] args) {
        nanTest();
        doubleTest();

    }

    /**
     * @param
     * @return void
     * @description 用于检测一个特定值是否为 NaN用于检测一个特定值是否为 NaN
     * @author MrNiurh
     **/
    private static void nanTest() {
        double num = Double.NaN;

        if (num == Double.NaN) {
            System.out.println("==:I can test it correctly");
        } else {
            System.out.println("==:I can not test it correctly");
        }

        if (Double.isNaN(num)) {
            System.out.println("isNaN(): I can test it correctly");
        } else {
            System.out.println("isNaN(): I can not test it correctly");
        }

        System.out.println("=======================================");
    }

    /**
     * @param
     * @return void
     * @description 浮点数值不适用于无法接受舍入误差的计算, 计算 （2.0 - 1.1） 的值
     * @author MrNiurh
     **/
    private static void doubleTest() {
        System.out.println((2.0 - 1.1));
    }

}



