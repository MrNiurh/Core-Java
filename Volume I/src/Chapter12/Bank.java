package Chapter12;

/**
 * @Author MrNiurh
 * @Date Creat in 2020/12/13
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Bank {

    private int count;
    private double cash;

    private double[] member = new double[100];

    public Bank(int count, double cash) {
        this.count = count;
        this.cash = cash;

        for (int i = 0; i < count; i++) {
            this.member[i] = cash;
        }
    }

    public void transfer(int from, int to, double amount) {
        member[from] -= amount;
        member[to] += amount;
    }

    public void printMethod() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + " : " + member[i]);
        }
    }

}
