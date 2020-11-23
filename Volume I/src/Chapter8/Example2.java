package Chapter8;

import Chapter6.Employee;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/23
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example2 {

    // 8.5.1 类型擦除
    /**
        原始类型用第一个限定来替换变量类型，或者，如果没有给定限定，就替换为 Object。例如，类 Pair<T> 中的类型变量没有显式的限定，因此，原始类型
     用 Object 替换 T。假定我们声明了一个稍有不同的类型：
        public class Interval<T extends Comparable & Serializable> implements Serializable{
            private T lower;
            private T upper;
            ...
            public Interval(T first, T second){
                if(first.compareTo(second) <= 0){
                    lower = first;
                    upper = second;
                }else{
                    lower = second;
                    upper = first;
                }
            }
        }

        原始类型 Interval 如下所示：
        public class Interval implements Serializable{
            private Comparable lower;
            private Comparable upper;
            ...
            public Interval(Comparable first, Comparable second){
                . . .
            }
        }

     限定切换为 class Interval<T extends Serializable & Comparable> 会发生什么？
     如果这样做，原始类型会用 Serializable 替换 T，而编译器在必要时要向 Comparable 插入强制类型转换。
     为了提高效率，应该将标签（tagging）接口（即没有方法的接口）放在限定列表的末尾。
     */


    // 8.5.2 转换泛型表达式
    public static void main(String[] args) {

        /**
         * 如果擦除了返回类型，编译器会插入强制的类型转换
         * getFirst 擦除类型后的返回类型是 Object。编译器会自动插入转换到 Employee 的强制类型转换。
         */
        Pair<Employee> buddies = new Pair<>(new Employee("ok", 12), new Employee("no", 13));
        Employee buddy = buddies.getFirst();
        /**
         * 当访问一个泛型字段时也要插入强制类型转换。
         * 假设 Pair 类的 first 字段和 second 字段都是公共的。表达式
         *      Employee buddy = buddies.first;
         * 也会在字节码中插入强制类型转换。
         */
    }
}
