package Chapter8;

import java.util.ArrayList;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/25
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example3 {

    public static void main(String[] args) {

        /**
         * 不能实例化参数化类型的数组
         */
        // var table = new Pair<String>[10];

        /**
         * 如果需要手机参数化类型对象，简单地使用 ArrayList 更安全、有效
         */
        ArrayList<Pair<String>> list = new ArrayList<>();


        /**
         * 不能在类似 new T(...) 的表达式中使用类型变量。例如，下面的 Pair<T> 构造器就是非法的：
         */

        /**
         public Pair(){
         first = new T();
         second = new T();
         }
         */

        /**
         * 表达式 T.class 是不合法的，因为它会擦除为 Object.class。
         */


        /**
         * 不能构造泛型数组
         */

        /**
         public static <T extends Comparable > T[] minmiax(T...a){
         T[] mm = new T[2]; // ERROR
         }
         */


        /**
         * 不能在静态字段或方法中引用类型变量。
         */

        /**
         public class Singleton<T> {

            private static T singleInstance;

            public static T getSingleInstance(){
                ...
            }
         }
         */



        /**
         * 不能抛出或捕获泛型类的实例
         */

        // public class Problem<T> extends Exception{}

        /**
         * catch 子句中不能使用类型变量
         */

        // catch(T e)
    }

}


