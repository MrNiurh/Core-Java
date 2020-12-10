package Chapter9;

import Chapter6.Employee;

import java.util.HashMap;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/10
 * @description This program demonstrates the use of a map with key type String and value type Employee.
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class MapTest {

    // 9.4 映射
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee", 10000));
        staff.put("567-24-2564", new Employee("Harry Hacker", 10000));
        staff.put("157-62-7935", new Employee("Amy Lee", 10000));
        staff.put("456-62-5527", new Employee("Amy Lee", 10000));

        // print all entries
        System.out.println(staff);

        staff.remove("567-24-2564");

        // replace an entry

        staff.put("456-62-5527", new Employee("Frank Miller", 20000));

        // iterate through all entries

        staff.forEach((k, v) -> System.out.printf("key=%s,value=%s", k, v));
    }
}
