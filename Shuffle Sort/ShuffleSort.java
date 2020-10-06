import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * monkey sort is another popular alias for shuffle sort.
 * Some also like to call it stupid sort
 */
public class ShuffleSort {

    private Random rnd = new Random();

    public void sort(List<Integer> list) {
        while(isSorted(list)) {
            System.out.println("...not sorted, about to shuffle");
            Collections.shuffle(list, rnd);
        }
        System.out.println("...sorted!");
    }

    private boolean isSorted(List<Integer> list) {
        Integer prev = null;
        for (int current : list) {
            if (prev != null && current > prev) return false;
            prev = current;
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4);
        new ShuffleSort().sort(list);
    }
}
