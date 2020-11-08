package Chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/7
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ReflectionTest {

    // 5.7 反射
    public static void main(String[] args) throws ReflectiveOperationException {

        // read class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        // print class name and superclass name (if != Object)
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
        System.out.print("class " + name);

        if (supercl != null && supercl != Object.class) {
            System.out.print(" extends " + supercl.getName());
        }

        System.out.print("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");

        /**
         * java.lang.Class
         *
         * Field[] getFields()
         * Field[] getDeclaredFields() getField 方法返回一个包含 Field 对象的数组，这些对象对应这个类或其超类的公共字段。
         *      getDeclaredField 方法也返回包含 Field 对象的数组，这些对象对应这个类的全部字段。如果类中没有字段，或者Class
         *      对象描述的是基本类型或数组类型，这些方法将返回一个长度为 0 的数组。
         * Method[] getMethods()
         * Method[] getDeclaredMethods() getMethods 将返回所有的公共方法，包括从超类继承来的公共方法；getDeclaredMethods
         *      返回这个类或接口的全部方法，但不包括由超类继承的方法。
         * Constructors[] getConstructors()
         * Constructors[] getDeclaredConstructors() 返回包含 Constructors 对象的数组，其中包含 Class 对象所表示的类的
         *      所有公共构造器(getConstructors)或全部构造器(getDeclaredConstructors)。
         * String getPackageName() 得到包含这个类型的包的包名，如果这个类型是一个数组类型，则返回元素类型所属的包，或者如果
         *      这个类型是一个基本类型，则返回 "java.lang"
         */

        /**
         * java.lang.reflect.Field
         * java.lang.reflect.Method
         * java.lang.reflect.Constructor
         *
         * Class getDeclaringClass() 返回一个 Class 对象，表示定义了这个构造器、方法或字段的类。
         * Class[] getExceptionTypes() (在 Constructor 和 Method classes 类中) 返回一个 Class 数组对象，其中各个对象
         *      表示这个方法所抛出异常的类型。
         * int getModifiers() 返回一个整数，描述这个构造器、方法或字段的修饰符。使用 Modifier 类中的方法来分析这个返回值。
         * String getName() 返回一个 Class 对象数组，其中各个对象表示参数的类型。
         * Class getReturnType() (在 Method 类中)返回一个用于表示返回类型的 Class 对象
         */

        /**
         * java.lang.reflect.Modifier
         *
         * static String toString(int modifiers) 返回一个字符串，包含对应 modifiers 中位设置的修饰符。
         * static boolean isAbstract(int modifiers)
         * static boolean isFinal(int modifiers)
         * static boolean isInterface(int modifiers)
         * static boolean isNative(int modifiers)
         * static boolean isPrivate(int modifiers)
         * static boolean isProtected(int modifiers)
         * static boolean isPublic(int modifiers)
         * static boolean isStatic(int modifiers)
         * static boolean isStrict(int modifiers)
         * static boolean isSynchronized(int modifiers)
         * static boolean isAbstract(int modifiers)
         * 这些方法将检测 modifiers 值中与方法名中修饰符对应的二进制位。
         */

    }

    /**
     * Prints all constructors of a class
     * 类中的所有构造器
     *
     * @param cl
     * @return void
     */
    private static void printConstructors(Class cl) {

        Constructor[] constructors = cl.getConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + "  ");
            }
            System.out.print(name + "(");

            // print parameters types
            Class[] parameterType = c.getParameterTypes();

            for (int i = 0; i < parameterType.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(parameterType[i].getName());
            }
            System.out.println(");");
        }


    }

    /**
     * Prints all methods of a class
     * 类中的所有方法
     *
     * @param cl
     * @return void
     */
    private static void printMethods(Class cl) {

        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("  ");

            // print modifiers,return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paramTypes = m.getParameterTypes();

            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");

        }
    }


    /**
     * Prints all fields of a class
     * 打印类的所有字段
     *
     * @param cl
     * @return void
     */
    private static void printFields(Class cl) {

        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());

            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
