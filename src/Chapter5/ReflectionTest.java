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
