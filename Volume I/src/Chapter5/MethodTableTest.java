package Chapter5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/13
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class MethodTableTest {

    // 5.7.7 调用任意方法和构造器
    public static void main(String[] args) throws ReflectiveOperationException {

        // get method printers to the square and sqrt methods
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // print tables of x- and y-values
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);

        /**
         * java.lang.reflect.Method
         *
         * public Object invoke(Object implicitParameter, Object[] explicitParameters) 调用这个对象描述的方法，传入给定参数，并
         *      返回方法的返回值。对于静态方法，传入 null 方法作为隐式参数。使用包装器传递基本值类型。基本类型的返回值必须是未包装的。
         */

    }

    /**
     * Returns the square of a number
     *
     * @param x
     * @return double
     */
    public static double square(double x) {
        return x * x;
    }

    /***
     * Prints a table with x- and y-values for a method
     * 从 from 到 to 的 n 个数据（等差）
     * @param from  the lower bound for the x-values
     * @param to    the upper bound for the x-values
     * @param n     the number of rows in the table
     * @param f     a method with a double parameter and double return value
     * @return void
     */
    private static void printTable(double from, double to, int n, Method f) throws ReflectiveOperationException {
        // print out the method as table header
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        // 平方 & 平方根 输出
        for (double x = from; x <= to; x += dx) {
            double y = (Double) f.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }
}
