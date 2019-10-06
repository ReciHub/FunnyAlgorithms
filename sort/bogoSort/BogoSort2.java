import java.util.Collections;
import java.util.List;

public class BogoSort {
    public static List<Integer> bogoSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (!(list.get(i) < list.get(i + 1))) {
                Collections.shuffle(list);
                bogoSort(list);
            }
        }
        return list;
    }
}
