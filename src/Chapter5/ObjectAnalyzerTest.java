package Chapter5;

import java.util.ArrayList;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/8
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ObjectAnalyzerTest {

    // 5.7.5 使用反射在运行时分析对象

    /**
     * This program uses reflection to spy on objects.
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) throws ReflectiveOperationException {

        var squares = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }

    /**
     * java.lang.reflect.AccessibleObject
     *
     * void setAccessible(boolean flag) 设置或取消这个可访问对象的可访问标志，如果拒绝则抛出一个 IllegalAccessException 异常。
     * boolean trySetAccessible() 为这个可访问的对象设置可访问对象设置可访问标志，如果拒绝则返回 false。
     * boolean isAccessible() 得到这个可访问对象的可访问标志。
     * static void setAccessible(AccessibleObject[] array, boolean flag) 这是一个便利方法，用于设置对象数组的可访问标志。
     */

    /**
     * java.lang.Class
     *
     * Field getField(String name)
     * Field[] getFields() 得到指定名的公共字段，或所有这些字段的一个数组。
     * Field getDeclaredField(String name)
     * Field[] getDeclareFields() 得到类中声明的指定名的字段，或者所有这些字段的一个数组。
     */

    /**
     * java.lang.reflect.Field
     *
     * Object get(Object obj) 返回对象中用这个 Field 对象描述的字段的值。
     * void set(Object obj, Object newValue) 将 obj 对象中的这个 Field 对象描述的字段色设置为一个新值。
     */
}
