package Chapter4;


/**
 * @author MrNiurh
 * @description This program demonstrates parameter in Java
 * @date Creat in 2020/10/7
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example2 {

    // 4.5 方法参数
    public static void main(String[] args) {

        // 一个方法不可能修改基本数据类型的参数
        double salary = 1000;
        tripleSalary(salary);
        System.out.println(salary);// salary = 1000.0

        // 修改对象参数有持久效果
        Employee e = new Employee("John", 1000, 2020, 10, 7);
        tripleSalary(e);
        System.out.println(e.getSalary());// salary = 3000.0

        // 测试对象交换
        /*
            swap 方法的参数 x 和 y 初始化为两个对象引用的副本，这个方法交换的是这两个副本。
            原来的变量 x 和 y 仍然引用这个方法调用之前所引用的对象。
            这个过程说明:Java 程序设计语言对对象采用的不是按引用调用，实际上，对象引用是按值传递的。
            交换对象参数没有持久效果
         */
        var x = new Employee("X", 1000, 2020, 10, 8);
        var y = new Employee("Y", 1010, 2020, 10, 8);
        swap(x, y);
        System.out.printf("x:%s,y:%s", x.getName(), y.getName());


    }

    /**
     * 虚假的薪水 *3
     *
     * @param salary 原薪水
     * @return void
     */
    public static void tripleSalary(double salary) {
        salary = salary * 3;
    }

    /**
     * 真实的薪水 *3
     *
     * @param e 员工对象
     * @return void
     */
    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
    }

    /**
     * 测试交换对象，如果 Java 对象采用的是按引用调用，那么这个方法可以实现交换
     *
     * @param x 员工对象1
     * @param y 员工对象2
     * @return void
     */
    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }

}
