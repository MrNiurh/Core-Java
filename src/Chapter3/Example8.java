package Chapter3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/27
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example8 {

    // 大数
    public static void main(String[] args) {
        bigIntegerTest();
        bigDecimalTest();
    }

    /**
     * 任意精度的整数运算
     *
     * @return void
     */
    private static void bigIntegerTest() {
        // 将普通的数值转换为大数
        BigInteger a = BigInteger.valueOf(100);

        BigInteger reallyBig = new BigInteger("12332112345677654321");
        BigInteger veryBig = new BigInteger("12345678987654321");

        BigInteger addResult = reallyBig.add(veryBig);// 大数的加法
        BigInteger multiplyResult = addResult.multiply(veryBig.add(BigInteger.TWO));// 大数的乘法


        /*
            BigInteger add(BigInteger other)        大数的和
            BigInteger subtract(BigInteger other)   差
            BigInteger multiply(BigInteger other)   积
            BigInteger divide(BigInteger other)     商
            BigInteger mod(BigInteger other)        余数
            BigInteger sqrt()                       平方根
            int compareTo(BigInteger other)         如果这个大整数与另一个大整数 other 相等，返回 0,小于则返回负数，大于返回正数
            static BigInteger valueOf(long x)       返回值等于 x 的大整数
         */

        int compareResult = multiplyResult.compareTo(addResult);// 1
    }

    /**
     * 任意精度的浮点数运算
     *
     * @return void
     */
    private static void bigDecimalTest() {
        /*
            BigDecimal add(BigDecimal other)                        大实数的和
            BigDecimal subtract(BigDecimal other)                   差
            BigDecimal multiply(BigDecimal other)                   积
            BigDecimal divide(BigDecimal other)                     商
            BigDecimal divide(BigDecimal other, RoundingMode mode)  如果商是个无限循环小数，第一个 divide 方法会抛出一个异常。要得到
                                                                    一个舍入的结果，需要使用第二个方法
            int compareTo(BigDecimal other)                         如果这个大实数与另一个大实数 other 相等，返回 0,小于则返回负数，
                                                                    大于返回正数
            static BigDecimal valueOf(long x)                       返回值等于 x 的大实数
            static BigDecimal valueOf(long x, int scale)            返回值等于 x/10^scale 的一个大实数
          */

        BigDecimal reallyBig = new BigDecimal("0.12345678987654321");
        BigDecimal veryBig = new BigDecimal("2.12345678987654321");

        //BigDecimal divideResult = reallyBig.divide(veryBig); //报错
        BigDecimal divideResult = reallyBig.divide(BigDecimal.valueOf(1));
        BigDecimal divideResult2 = veryBig.divide(reallyBig, RoundingMode.CEILING);// 有结果
    }
}
