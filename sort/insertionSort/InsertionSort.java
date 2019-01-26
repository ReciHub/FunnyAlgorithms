import java.util.Random;

class InsertionSort{

	public static void insertionSort(int arr[]){

		int j, key;

		for(int i=1; i<arr.length; i++){
			key = arr[i];
			j = i-1;
			while( j >= 0 && key < arr[j] ){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

	public static void printArray(int arr[]){
		for(int x : arr)
			System.out.print(x + ", ");
	}

	public static void main(String args[]){

		int arr[] = new int[10];
		Random rand = new Random();

		for(int i=0; i<10; i++)
			arr[i] = rand.nextInt(100);

		System.out.print("\nOrignal Array : ");
		printArray(arr);

		insertionSort(arr);

		System.out.print("\n Sorted Array : ");
		printArray(arr);

		System.out.println("\n");
	}
}
