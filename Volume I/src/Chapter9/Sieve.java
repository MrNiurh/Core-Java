package Chapter9;

import java.util.BitSet;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/13
 * @description This program runs the Sieve of Erathostenes benchmark.It computes all primes up to 2,000,000.
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Sieve {

    // 9.7.5 位集

    /**
     * 遍历一个包含 200 万个位的位集。首先将所有的位置为“开”状态，然后，将已知素数的倍数所对应的位都置为“关”状态。
     *
     * @param args
     * @return void
     */
    public static void main(String[] args) {

        int n = 2000000;
        long start = System.currentTimeMillis();

        var bitSet = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            // 设置一个位
            bitSet.set(i);
        }
        i = 2;

        while (i * i <= n) {
            if (bitSet.get(i)) {
                count++;
                // 清除 i 的倍数位
                int k = 2 * i;
                while (k <= n) {
                    // 清除一个位
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }

        i = 2;
        while (i <= n) {
            if (bitSet.get(i)) count++;
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " ms");
    }
}
