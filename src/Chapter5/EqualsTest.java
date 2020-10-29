package Chapter5;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/28
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class EqualsTest {

    /**
     * 相等测试
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        var alice1 = new Employee("Alice", 75000, 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Employee("Alice", 75000, 1987, 12, 15);
        var bob = new Employee("Bob", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2:" + (alice1 == alice2));
        System.out.println("alice1 == alice3:" + (alice1 == alice3));

        System.out.println("alice1.equals(alice3):" + alice1.equals(alice3));
        System.out.println("alice1.equals(bob):" + alice1.equals(bob));

        System.out.println("bob.toString():" + bob);

        System.out.println("alice1.hashCode():" + alice1.hashCode());
        System.out.println("alice2.hashCode():" + alice3.hashCode());
    }


}
