package Chapter5;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/15
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Employee {

    // 姓名
    private String name;
    // 薪水
    private double salary;
    // 雇佣日期
    private LocalDate hireDay;

    /**
     * 一个雇员
     *
     * @param name   姓名
     * @param salary 薪资
     * @param year   入职年份
     * @param month  入职月份
     * @param day    入职日
     * @return null
     */
    public Employee(String name, double salary, int year, int month, int day) {
        /*
            Java 9
            宽容型:把 null 参数转换为一个适当的非 null 值
            严格型:拒绝 null 参数
         */
        this.name = Objects.requireNonNullElse(name, "unknown");
        //Objects.requireNonNull(name, "The name cannot be null!");
        //this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
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

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}
