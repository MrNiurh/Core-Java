package Chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/9
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class CopyOfTest {

    // 5.7.6 使用反射编写泛型数组代码
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Jerry", "Rick"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * This method attempts to grow an array by allocating a new array of the same type and copying all elements
     *
     * @param a         the array to grow.This can be an object array or a primitive type array
     * @param newLength
     * @return a large array that contains all elements of a.
     */
    private static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));

        return newArray;
    }

    /**
     * This method attempts to grow an array by allocating a new array and copying all elements.
     *
     * @param a         the array to grow
     * @param newLength
     * @return a large array that contains all elements of a. However,the returned array has the type Object[],not the same type as a
     */
    private static Object badCopyOf(Object[] a, int newLength) {
        var newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }
}
