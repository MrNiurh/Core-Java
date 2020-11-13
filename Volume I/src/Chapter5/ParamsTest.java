package Chapter5;

import java.util.ArrayList;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/3
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ParamsTest {

    // 5.5 参数数量可变的方法
    public static void main(String[] args) {

        Integer count = Integer.valueOf(0);

        Employee e1 = new Employee("Alice", 11111, 2002, 12, 12);
        Employee e2 = new Employee("Boc", 22222, 2003, 12, 12);
        Employee e3 = new Employee("Carl", 3333, 2004, 12, 12);

        ParamsTest p = new ParamsTest();
        p.printStream(count, e1, e2, e3);

    }

    /**
     * 参数数量可变的方法
     *
     * @param count
     * @param employees
     * @return void
     */
    public void printStream(Integer count, Employee... employees) {
        for (Employee e : employees) {
            count++;
            System.out.printf("第%d个员工:name=%s,salary=%.2f,hireDay=%s\n", count, e.getName(), e.getSalary(), e.getHireDay());
        }
    }
}
