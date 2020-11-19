package Chapter6;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/18
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example3 {

    // 6.2.7 处理 lambda 表达式
    public static void main(String[] args) {

        repeat(10, () -> System.out.println("Hello,World!"));
        repeat(10, i -> System.err.println("Hello,World!"));

    }

    // 重复一个动作 n 次
    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    public interface IntConsumer {
        void accept(int value);
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
