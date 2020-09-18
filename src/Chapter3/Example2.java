package Chapter3;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/16
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example2 {
    public static void main(String[] args) {
        charTest();
    }


    /**
     * 转义字符的功能测试
     *
     * @return void
     */
    private static void charTest() {

        //System.out.println("\u0022 + \u0022");
        // 反斜杠：\
        // 反斜杠u000A 会替换为一个换行符，语法错误
        // System.out.println("反斜杠u000A is a newLine");
        // 反斜杠u后面没有跟着4个十六进制数，语法错误
        // System.out.println("look inside c:反斜杠users");
    }



}
