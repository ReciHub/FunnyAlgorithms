
 class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 6, 8, 5, 3, 7 };
		System.out.println("Before sorting");
		printArray(arr);
		arr = mergeSort(arr);
		System.out.println("After Sorting");
		printArray(arr);
	}

	public static int[] mergeSort(int[] arr) {
		int length = arr.length;
		if (length < 2)
			return arr;
		else {
			int mid = length / 2;
			int[] left = new int[mid];
			int[] right = new int[length - mid];

			for (int i = 0; i < mid; i++) {
				left[i] = arr[i];
			}
			int temp = length - mid;
			for (int i = 0; i < temp; i++) {
				right[i] = arr[mid];
				mid++;
			}

			mergeSort(left);
			mergeSort(right);
			merge(left, right, arr);
		}
		return arr;
	}

	public static int[] merge(int[] L, int[] R, int[] arr) {
		int nL = L.length;
		int nR = R.length;

		int i = 0, j = 0, k = 0;

		while (i < nL && j < nR) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
				k++;
			} else {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

		while (i < nL) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < nR) {
			arr[k] = R[j];
			j++;
			k++;
		}

		return arr;

	}

	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}

}
