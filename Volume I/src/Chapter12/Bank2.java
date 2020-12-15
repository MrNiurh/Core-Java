package Chapter12;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/13
 * @Description A bank with a number of bank accounts.
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Bank2 {

    private double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;


    // 12.4.4 条件对象
    public Bank2(int count, double initialBalance) {
        this.accounts = new double[count];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * Transfer money from one account to another.
     *
     * @param from
     * @param to
     * @param amount
     * @return void
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        // 使用锁来保护 Bank 类的 transfer 方法。
        bankLock.lock();
        try {
            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.notifyAll();
        } finally {
            /**
             * 要把 unlock 操作包括在 finally 子句中，如果在临界区的代码抛出一个异常，锁必须释放。否则，其他线程将永远阻塞。
             */
            bankLock.unlock();
        }


    }

    /**
     * Gets the sum of all account balances.
     *
     * @return double the total balance
     */
    public double getTotalBalance() {

        bankLock.lock();
        try {
            double sum = 0;

            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.lock();
        }
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
