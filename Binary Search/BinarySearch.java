import java.util.Scanner;
public class BinarySearch
{
    public static int binarySearch(final int[] num, final int left, int right, int x) {
        int mid;
        right = num.length;
        if(right>1) {
            mid = (left + right) / 2;
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
        System.out.println("Enter the number to be searched: ");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        System.out.println("Enter the length of array: ");
        int l = sc.nextInt();
        int number[];
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
