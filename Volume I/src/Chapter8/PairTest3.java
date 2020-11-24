package Chapter8;

import Chapter5.Employee;
import Chapter5.Manager;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/24
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class PairTest3 {

    // 8.8.4 通配符捕获
    public static void main(String[] args) {

        var ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        var cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        var buddies = new Pair<Manager>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};

        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ",second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ",second: " + result.getSecond().getName());
    }


    private static void printBuddies(Pair<? extends Employee> p) {

        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    private static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {

        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) {
                min = a[i];
            }
            if (max.getBonus() < a[i].getBonus()) {
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    private static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result);
    }

}

class PairAlg {

    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
