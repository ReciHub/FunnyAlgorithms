import java.util.*;

public class StalinSort {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,4,6,8,3,5,7,9,20,18,29);
		List<Integer> sorted = stalinSort(list);
		System.out.println(sorted);
	}

	public static <T extends Comparable<T>> List<T> stalinSort(List<T> list) {
		List<T> sorted = new ArrayList<>();
		for (T t : list)
			if (sorted.isEmpty() || sorted.get(sorted.size()-1).compareTo(t) <= 0)
				sorted.add(t);
		return sorted;
	}

}
