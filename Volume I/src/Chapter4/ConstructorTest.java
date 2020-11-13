package Chapter4;

import java.util.Random;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/13
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ConstructorTest {

    // 4.6 对象构造
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        var staff = new Person[3];

        staff[0] = new Person("Harry", 4000);
        staff[1] = new Person(60000);
        staff[2] = new Person();

        for (Person person : staff) {
            System.out.printf("name=%s,id=%d,salary=%8.2f.\n", person.getName(), person.getId(), person.getSalary());
        }

        // 产生随机数
        var generator = new Random();
        for (int i = 10; i > 0; i--) {
            //System.out.println(generator.nextInt(100));// 0 ~ (bound - 1)的一个值
            //System.out.println(generator.nextDouble());// 随机一个 Double 值
            //System.out.println(generator.nextLong());// 随机一个 Long 值
        }


    }

}
