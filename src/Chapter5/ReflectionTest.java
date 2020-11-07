package Chapter5;

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
     *
     * @param cl
     * @return void
     */
    private static void printConstructors(Class cl) {
    }

    /**
     * Prints all methods of a class
     *
     * @param cl
     * @return void
     */
    private static void printMethods(Class cl) {
    }


    /**
     * Prints all fields of a class
     *
     * @param cl
     * @return void
     */
    private static void printFields(Class cl) {
    }
}
