package Chapter8;

import java.time.LocalDate;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/22
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class PairTest2 {

    // 8.4 类型变量的限定
    public static void main(String[] args) {

        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22),
        };

        Pair<LocalDate> mm = ArrayAlg3.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

}

class ArrayAlg3 {

    /**
     * Gets the minimum and maximum of an array of objects of type T.
     *
     * @param a an array of objects of type T
     * @return a pair with the min and max values,or null if a is null or empty
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {

        /**
         * 为什么使用关键字 extends 而不是 implements,毕竟,Comparable 是一个接口
         * 记法 <T extends BoundingType> 表示 T 应该是限定类型(bounding type)的子类型(subtype)。T 和限定类型可以是类,也可以是接口。
         * 选择关键字 extends 的原因是它更接近子类型的概念，并且 Java 的设计者也不打算在语言中再添加一个新的关键字(如sub)
         * 一个类型变量或通配符可以有多个限定，例如：
         * T extends Comparable & Serializable
         * 限定类型用 “&” 分隔，而逗号用来分隔类型变量。
         */
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}