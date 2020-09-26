package Chapter3;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/26
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example7 {

    // 3.8 控制流程
    public static void main(String[] args) {
        controllTest();
    }

    /**
     * 控制流程的测试
     *
     * @return void
     */
    private static void controllTest() {

        // if,while,for,switch

        // 精度问题，不会停止
        for (double x = 0; x != 1; x += 0.1) {
            System.out.println("Counting down ... " + x);
            if (x > 10) break;// 跳出循环
        }
    }
}
