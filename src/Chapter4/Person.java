package Chapter4;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/12
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Person {

    // 姓名
    private String name;
    // 薪水
    private double salary;
    // 雇佣日期
    private LocalDate hireDay;

    private static int nextId;

    private int id = assignId();

    private static int assignId() {
        int r = nextId;
        nextId++;
        return r;
    }

    /**
     * 无参构造器
     * 仅当类没有任何其他构造器的时候，才会得到一个默认的无参数构造器
     */
    public Person() {
        String name = "";
        Double salary = 0.0;
        LocalDate hiryDay = LocalDate.now();
    }

    /**
     * 简单的有参构造器
     *
     * @param n
     * @param s
     * @param year
     * @param month
     * @param day
     */
    public Person(String n, Double s, int year, int month, int day) {
        this.name = Objects.requireNonNullElse(n, "unknown");
        this.salary = s;
        hireDay = LocalDate.of(year, month, day);
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
