import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Name: BozoSort
Description: Swaps two elements at random until the sequence is sorted. Much more difficult to analyse than Bogo or BogoBogo, but supposedly 𝑂(𝑛!) on average.
Functionality: Takes in an array of numbers and provides a sorted array
Usage: console.log(sorter([4, 8, 2, 7, 1, 6, 10]))
Output: ​​​​​[ 1, 2, 4, 6, 7, 8, 10 ]​​​​​ 
*/
public class BozoSort<T extends Comparable<T>> {

	public List<T> sort(final List<T> listToSort) {

		List<T> list = new ArrayList<>();
		list.addAll(listToSort);
		while (!isSorted(list)) {

			int slot1 = (int) Math.floor(Math.random() * list.size());
			int slot2 = (int) Math.floor(Math.random() * list.size());

			T temp = list.get(slot1);
			list.set(slot1, list.get(slot2));
			list.set(slot2, temp);
		}

		return list;
	}

	private static <C extends Comparable<C>> boolean isSorted(final List<C> list) {
		for (int i = 0; i < list.size(); i++) {

			if ((i + 1) == list.size()) {
				return true;
			}

			if (list.get(i).compareTo(list.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		final List<Integer> unsortedList = Arrays.asList(4, 8, 2, 7, 1, 6, 10);

		final BozoSort<Integer> bozoSorter = new BozoSort<>();
		final List<Integer> sortedList = bozoSorter.sort(unsortedList);

		for (int item : sortedList) {
			System.out.print(item + " ");
		}
		// Out[ 1, 2, 4, 6, 7, 8, 10 ]​​​​​
	}
}
