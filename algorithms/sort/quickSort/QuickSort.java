import java.util.Random;

class QuickSort{

	public static void quickSort(int arr[], int low, int high){

		if(high-low > 1){
			int pivot = high-1;
			int cmp = low-1;
			int temp;
			for(int i=low; i<pivot; i++){
				if(arr[i] < arr[pivot] ){
					cmp++;
					temp = arr[cmp];
					arr[cmp] = arr[i];
					arr[i] = temp;
				}
			}
			cmp++;
			temp = arr[pivot];
			arr[pivot] = arr[cmp];
			arr[cmp] = temp;
			quickSort(arr, low, cmp);
			quickSort(arr, cmp+1, high);
		}
	}

	public static void quickSort(int arr[]){
		quickSort(arr, 0, arr.length);
	}

	static void printArray(int arr[]){
		for(int x : arr)
			System.out.print(x + ", ");
	}

	public static void main(String args[]){

		Random r = new Random();
		int arr[] = new int[10];

		for(int i=0; i<10; i++){
			arr[i] = r.nextInt(200);
		}

		System.out.print("Orignal array : ");
		printArray(arr);

		quickSort(arr);

		System.out.print("\n Sorted array : ");
		printArray(arr);

		System.out.println();
	}
}
