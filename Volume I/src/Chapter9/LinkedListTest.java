package Chapter9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/29
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class LinkedListTest {


    // 9.3.1 链表
    public static void main(String[] args) {
        var a = new LinkedList<String>();

        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // merge the words from b into a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip next element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }

        System.out.println(b);

        // bulk operation: remove all words in b from a

        a.removeAll(b);

        System.out.println(a);
    }
}
