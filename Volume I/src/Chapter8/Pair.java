package Chapter8;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/21
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
