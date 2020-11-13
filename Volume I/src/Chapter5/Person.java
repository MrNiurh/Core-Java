package Chapter5;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/20
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public abstract class Person {

    public abstract String getDescription();

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
