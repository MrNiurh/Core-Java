package Chapter9;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        parts.add(new Item("Bob", 1234));
        parts.add(new Item("Author", 2536));
        parts.add(new Item("Dan", 6653));
        parts.add(new Item("Dan", 6653));
        parts.add(new Item("Dan", 9999));
        parts.add(new Item("Carl", 7542));

        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));

        System.out.println(parts);
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);


    }

}
