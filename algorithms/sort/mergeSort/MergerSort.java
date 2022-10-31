package mergeSort;

import java.util.*;

public class MergerSort {
	public static void main(String[] args) {
		// Unsorted array
		Integer[] a = { 2, 6, 3, 5, 1 };

		// Call merge sort
		mergeSort(a);

		// Check the output which is sorted array
		System.out.println(Arrays.toString(a));
	}

	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] list) {
		// If list is empty; no need to do anything
		if (list.length <= 1) {
			return list;
		}

		// Split the array in half in two parts
		Comparable[] first = new Comparable[list.length / 2];
		Comparable[] second = new Comparable[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		// Sort each half recursively
		mergeSort(first);
		mergeSort(second);

		// Merge both halves together, overwriting to original array
		merge(first, second, list);
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
		// Index Position in first array - starting with first element
		int iFirst = 0;

		// Index Position in second array - starting with first element
		int iSecond = 0;

		// Index Position in merged array - starting with first position
		int iMerged = 0;

		// Compare elements at iFirst and iSecond,
		// and move smaller element at iMerged
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		// copy remaining elements from both halves - each half will have already sorted
		// elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
}