package Chapter5;

import java.util.ArrayList;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/29
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ArrayListTest {

    // 5.3 泛型数组列表
    public static void main(String[] args) {

        // fill the staff list with three Employee objects
        var staff = new ArrayList<Employee>();

        staff.add(new Employee("Alice", 11111, 2002, 12, 12));
        staff.add(new Employee("Boc", 22222, 2003, 12, 12));
        staff.add(new Employee("Carl", 3333, 2004, 12, 12));

        // raise everyone's salary by 5%
        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.printf("name=%s,salary=%.2f,hireDay=%s\n", e.getName(), e.getSalary(), e.getHireDay());
        }


    }
}
