package Chapter9;


import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/4
 * @description This program sorts a set of Item objects by comparing their description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class TreeSetTest {

    // 9.3.4 树集
    public static void main(String[] args) {

        var parts = new TreeSet<Item>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));

        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }
}
