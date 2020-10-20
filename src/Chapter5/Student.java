package Chapter5;

/**
 * @author MrNiurh
 * @date Creat in 2020/10/20
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Student extends Person {

    private String major;

    /**
     * @param name  the student's name
     * @param major the student's major
     */
    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
