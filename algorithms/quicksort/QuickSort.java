import java.util.Scanner;

public class QuickSort {
  static int partition (int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++)
        {

            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    static void quickSort(int arr[] , int beg , int end )
    {
        if(beg <end)
        {
            int pivotIndex = partition(arr,beg , end);
            quickSort(arr , beg , pivotIndex-1);
            quickSort(arr , pivotIndex+1 , end);
        }
    }

    static void print(int arr[],int n)
    {

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int [n];
        System.out.print("Enter elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Array before sort: ");
        print(arr,n);
        quickSort(arr,0,n-1);
        System.out.print("Array after sort: ");
        print(arr,n);

    }
}
