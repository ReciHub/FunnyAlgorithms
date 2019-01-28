import java.util.Random;

class BubbleSort{

	public static void bubbleSort(int arr[]){

		int temp;

		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length-i-1; j++){
				if( arr[j] > arr[j+1] ){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	static void printArray(int arr[]){
		for(int x : arr)
			System.out.print(x + ", ");
	}

	public static void main(String args[]){

		int arr[] = new int[10];
		Random r = new Random();

		for(int i=0; i<10; i++){
			arr[i] = r.nextInt(100);
		}

		System.out.print("Orignal array : ");
		printArray(arr);

		bubbleSort(arr);

		System.out.print("\n Sorted array : ");
		printArray(arr);

		System.out.println();
	}
}
