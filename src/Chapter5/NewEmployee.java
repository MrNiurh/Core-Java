package Chapter5;

import java.time.LocalDate;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/21
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class NewEmployee extends Person {

    // 薪资
    private double salary;
    // 入职时间
    private LocalDate hireDay;

    public NewEmployee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of %.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public double getSalary() {
        return salary;
    }


    public LocalDate getHireDay() {
        return hireDay;
    }
}
