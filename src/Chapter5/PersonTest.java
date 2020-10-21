package Chapter5;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/20
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class PersonTest {

    public static void main(String[] args) {
        var people = new Person[2];

        people[0] = new NewEmployee("Harry Hacker", 5000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        // print out names and descriptions of all Person objects
        for (Person p : people) {
            System.out.printf("%s,%s\n", p.getName(), p.getDescription());
        }
    }
}
