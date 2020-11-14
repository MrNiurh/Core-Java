package Chapter6;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/15
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Employee implements Comparable<Employee> {

    // 姓名
    private String name;
    // 薪水
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    /**
     * 涨薪方法
     *
     * @param byPercent 涨薪百分比
     * @return void
     */
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    /**
     * Compares employees by salary
     *
     * @param other another Employee object
     * @return a negative value if this employee has a lower salary than otherObject,0 if the salaries are the same,a
     * positive value otherwise
     */
    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}
