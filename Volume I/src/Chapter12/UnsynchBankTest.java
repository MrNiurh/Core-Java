package Chapter12;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/14
 * @Description This program shows data corruption when multiple threads access a data structure.
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class UnsynchBankTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    // 12.4.1 竞态条件的一个例子
    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            var t = new Thread(r);
            t.start();

        }
    }

}
