import java.util.Scanner;

/**
 * Objective :
 * Push all the zero’s of a given array to the end of the array. 
 * The order of all other elements should be same.
 * 
 * For example :
 * If the given arrays is 		{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
 * Then it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
 * 
 * Time complexity is O(n) and Space complexity is O(1)
 *
 */
public class PushZeros {
	
	// Function which pushes all zeros to end of an array.
	static void pushZerosToEnd(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is
		// non-zero, then replace the element at index 'count'
		// with this element
		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i]; // here count is incremented

		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < n)
			arr[count++] = 0;
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = kb.nextInt();
		
		pushZerosToEnd(arr, n);
		System.out.println("Array after pushing zeros to the back: ");
		
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
