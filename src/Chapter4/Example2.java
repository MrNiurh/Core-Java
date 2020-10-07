package Chapter4;

/**
 * @author MrNiurh
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

    }

    /**
     * 虚假的薪水 *3
     *
     * @param salary
     * @return void
     */
    public static void tripleSalary(double salary) {
        salary = salary * 3;
    }

    /**
     * 真实的薪水 *3
     *
     * @param e
     * @return void
     */
    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
    }


}
