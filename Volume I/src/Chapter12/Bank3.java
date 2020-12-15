package Chapter12;

import java.util.Arrays;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/15
 * @Description A bank with bank accounts that uses synchronization primitives.
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Bank3 {

    // 12.4.5 synchronized 关键字
    private double[] accounts;

    public Bank3(int count, double initialBalance) {
        this.accounts = new double[count];
        Arrays.fill(accounts, initialBalance);

    }

    /**
     * Transfer money from one account to another.
     *
     * @param from
     * @param to
     * @param amount
     * @return void
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    /**
     * Gets the sum of all account balances.
     *
     * @return double the total balance
     */
    public double getTotalBalance() {
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     *
     * @return int the number of accounts
     */
    public int size() {
        return accounts.length;
    }

}
