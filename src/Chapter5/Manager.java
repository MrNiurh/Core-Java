package Chapter5;

import Chapter5.Employee;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/15
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Manager extends Employee {

    private double bonus;

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
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
