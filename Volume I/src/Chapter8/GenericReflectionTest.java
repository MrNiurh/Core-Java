package Chapter8;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/26
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class GenericReflectionTest {


    // 8.9.3 虚拟中的泛型类型信息
    public static void main(String[] args) {

        // read class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            try (var in = new Scanner(System.in)) {
                System.out.println("Enter class name (e.g.,java.util.Collections): ");
                name = in.next();
            }
        }

        try {
            // print generic info for class and public methods
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for (Method m : cl.getDeclaredMethods()) {
                printMethod(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void printClass(Class<?> cl) {
    }

    private static void printMethod(Method m) {
    }

}
