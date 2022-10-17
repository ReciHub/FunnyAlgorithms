
public class BubbleSort {
	static int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
	
	public static void main(String[] args) {
		 int n = arr.length;
		 bubbleSort(arr, n);
		 System.out.println("Sorted Array:");
		 printArray(arr, n);
	}

	/* Function to print an array */
	private static void printArray(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}

	// A function to implement bubble sort 
	private static void bubbleSort(int[] arr, int n) {
		int i,j;
		boolean flag = false;
		for(i=0; i<n-1; i++) {
			flag=false;
			for(j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
			        flag=true;
				}
			}
			if(flag==false)
		        break;
		}
	}
}
