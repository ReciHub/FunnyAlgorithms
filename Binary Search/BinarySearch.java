import java.util.Scanner;
//This algorithm only works if the array is sorted in ascending order.
public class BinarySearch
{
    public static int binarySearch(final int[] num, final int left, int right, int x) {
        int mid;
        right = num.length;
        if(right>1) {
            mid = left+(right-left)/2; // we could also have written (left+right)/2 but there might be some cases where overflow can be seen in memory.
            if(num[mid] == x)
               return mid;
            if(num[mid]>x)
                return binarySearch(num, left, right - 1, x);
            if(num[mid]<x)
                return binarySearch(num,mid+1,right,x);
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        //Taking the input for the number to be searched in the array
        System.out.println("Enter the number to be searched: ");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        //Taking the input for the length of the array
        System.out.println("Enter the length of array: ");
        int l = sc.nextInt();
        int number[];
        //Taking the input for the elements in the array
        System.out.println("Enter the Array: ");
        for(int i = 0; i < l; i++)
        {
            number[i] = sc.nextInt();
        }
        int result = b.binarySearch(number,0,0,find);
        if(result == -1)
        {
            System.out.println("Element not present in array");
        }
        else {
            System.out.println("Element present in array at: " + result);
        }
    }
}
