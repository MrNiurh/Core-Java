package Chapter8;

/**
 * @author MrNiurh
 * @date Creat in 2020/11/21
 * @description
 * @see <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class PairTest1 {

    // 8.2 定义简单泛型类
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "little", "a", "lamb"};
        String[] test = null;
        Pair<String> mm = ArrayAlg.minmax(words);

        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg {

    /**
     * Gets the minimum and maximum of an array of strings.
     * 按照字典顺序（A-Z,a-z）
     *
     * @param a an array of strings
     * @return a pair with the min and max values, or null if a is null or empty
     */
    public static Pair<String> minmax(String[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
