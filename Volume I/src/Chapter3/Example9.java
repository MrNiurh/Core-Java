package Chapter3;

import java.util.Arrays;

/**
 * @author MrNiurh
 * @date Creat in 2020/9/28
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Example9 {

    // 3.10 数组
    public static void main(String[] args) {
        arrayTest();
        irregularArrayTest();
    }

    /**
     * 数组的测试
     *
     * @return void
     */
    private static void arrayTest() {

        int[] smallPrimes = {5, 3, 2, 7, 13, 11};

        // for each 循环
        // for each 循环语句的循环变量将会遍历数组中的每个元素，而不是下标值
        for (int x : smallPrimes) {
            System.out.print(x + " ");
        }
        System.out.println();

        // 打印数组中的所有值
        System.out.println("smallPrimes:" + Arrays.toString(smallPrimes));// [5, 3, 2, 7, 13, 11]

        // 数组长度为 0,但是不为空
        int[] nullTest = new int[0];
        if (nullTest.equals(null)) {
            System.out.println("Null!");
        } else {
            System.out.println("nullTest.length:" + nullTest.length);
        }

        // 数组拷贝
        int[] copyArray = Arrays.copyOf(smallPrimes, smallPrimes.length);

        System.out.println("copyArray:" + Arrays.toString(copyArray));


        // 两个数组之间的对比
        if (copyArray == smallPrimes) {
            System.out.println("== is ok");
        } else if (copyArray.equals(smallPrimes)) {
            System.out.println("equals is ok");
        } else if (Arrays.equals(copyArray, smallPrimes)) {
            System.out.println("Arrays.equals is ok");
        } else {
            System.out.println("not ok");
        }

        /*
            数组扩容
            如果数组元素是数值型，那么额外的元素将被赋值为 0
            如果数组元素是布尔型，则将赋值为 false
            如果长度小于原始数组的长度，则只拷贝前面的值
         */
        smallPrimes = Arrays.copyOf(smallPrimes, 2 * smallPrimes.length);
        System.out.println("smallPrimes:" + Arrays.toString(smallPrimes));

        // 数组排序
        Arrays.sort(copyArray);
        System.out.println("sort copyArray:" + Arrays.toString(copyArray));

        /*
            toString()  // 返回字符串，元素用中括号包围，逗号分隔   见上
            copyOf(xxx[] a, int end)    // 复制数组
            sort()      //数组排序

            static xxx[] copyOfRange(xxx[] a, int start, int end)   返回与 a 同类型的数组，长度为
                end - start,数组元素为 a 的值。如果 end 大于 a.length,结果会填充 0 或 false 值。
            static int binarySearch(xxx[] a, xxx v)
            static int binarySearch(xxx[] a, int start, int end, xxx v)
                使用二分查找算法在有序数组 a 中查找值 v。如果找到 v,则返回对应的下标；否则，则返回一个数值 r。
                -r-1 是 v 应插入的位置(为保持 a 有序)
            static void fill(xxx[] a, xxx v)    将数组所有数据元素设置为 v
         */

        Arrays.binarySearch(copyArray, 13); // 下标5

        // 二维数组
        int[][] magicSquare = {
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}
        };

        // 二维数组输出
        for (int[] row : magicSquare) {
            for (int value : row) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }

        // 二维数组输出
        // [[16, 3, 2, 13], [5, 10, 11, 8], [9, 6, 7, 12], [4, 15, 14, 1]]
        System.out.println(Arrays.deepToString(magicSquare));
    }

    /**
     * 不规则数组测试
     *
     * @return void
     */
    private static void irregularArrayTest() {
        int Max = 7;// 定义数组的行数
        int[][] odds = new int[Max][];

        // 每行的元素个数
        for (int n = 0; n < Max; n++) {
            odds[n] = new int[n + 1];
        }

        // 给数组赋值
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }
                odds[n][k] = lotteryOdds;
            }
        }

        // 格式化输出数组内容
        for (int[] row : odds) {
            for (int value : row) {
                System.out.printf("%4d", value);// 数据宽度为 4
            }
            System.out.println();
        }

        /* 结果输出 Max = 7;
               1
               1   2   1
               1   3   3   1
               1   4   6   4   1
               1   5  10  10   5   1
               1   6  15  20  15   6   1
         */
    }
}
