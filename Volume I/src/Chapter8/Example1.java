package Chapter8;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/21
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example1 {

    // 8.3 泛型方法
    public static void main(String[] args) {
        String middle = ArrayAlg2.getMiddle("John", "Q.", "Public");
        System.out.println(middle);

        /**
         * 编译器将把参数自动装箱为 1 个 Double 和 2 个 Integer 对象，然后共同寻找这些类的共同超类型。
         * 事实上，它找到了 2 个超类型：Number 和 Comparable 接口，Comparable 接口本事也是一个泛型类型。
         * 在这种情况下，可以采取的补救措施时将所有的参数都写为 double 值。
         */
        // double middleNum = ArrayAlg2.getMiddle(3.14, 1792, 0);
    }

}

class ArrayAlg2 {

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

}
