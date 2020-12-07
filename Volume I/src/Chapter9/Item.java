package Chapter9;

import java.util.*;

/**
 * @author MrNiurh
 * @date Creat in 2020/12/4
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {

        this.description = description;
        this.partNumber = partNumber;
    }

    /**
     * Gets the description of this item.
     */
    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[description='" + description + ", partNumber=" + partNumber + ']';
    }

    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Item) otherObject;
        return Objects.equals(description, other.getDescription()) && partNumber == other.partNumber;

    }

    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
