package Chapter5;

import java.util.ArrayList;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/8
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class ObjectAnalyzerTest {

    // 5.7.5 使用反射在运行时分析对象

    /**
     * This program uses reflection to spy on objects.
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) throws ReflectiveOperationException {

        var squares = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
