package Chapter12;

import java.util.Arrays;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/13
 * @Description A bank with a number of bank accounts.
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Bank {

    private double[] accounts;

    public Bank(int count, double initialBalance) {
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
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
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
