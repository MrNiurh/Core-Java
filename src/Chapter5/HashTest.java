package Chapter5;

import java.util.Objects;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/24
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class HashTest {

    /**
     * 5.2.4 hashCode 测试
     * param args
     * @return void
     */
    public static void main(String[] args) {

        // 计算数组的散列码
        Employee[] employee = new Employee[2];
        employee[0] = new Employee("OK", 20000, 2012, 12, 12);
        employee[1] = new Employee("OK", 20000, 2012, 12, 12);
        System.out.println(Objects.hashCode(employee));

        // 有提供的所有对象的散列码组合而得到
        System.out.println(Objects.hash(employee[0], employee[1]));

        // 返回基本类型
        Integer number = 10;
        System.out.println(Objects.hashCode(12));
        System.out.println(number.hashCode());
        System.out.println("OK6666666666666".hashCode());


        // null 安全，参数为空则返回 0
        Employee employee1 = null;
        System.out.println(Objects.hashCode(employee1));




    }
}
