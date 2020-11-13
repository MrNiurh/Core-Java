package Chapter4;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/30
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class EmployeeTest {

    // 4.3 用户自定义类
    public static void main(String[] args) {

        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[4];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        staff[3] = new Employee(null, 40000, 1990, 3, 15);

        // 测试用户名为空的情况
        String name = staff[3].getName();

        // raise everyone's salary by 5%
        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.printf("name=%s, salary=%8.2f, hireDay=%s.\n", e.getName(),
                    e.getSalary(), e.getHireDay());
        }
    }
}
