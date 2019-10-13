import java.util.*;

//2 Pivot partition is used to rearrange an array in-place such that
// for two pivots high and low, the first half of the array is < low.
//second half is >=low and <= high
//third half is > high

class TwoPivotPartition{
 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);

  int n = sc.nextInt();
  int[] a = new int[n];

  for(int i = 0; i < n; i++)
  	a[i] = sc.nextInt();

  int low = 0, mid = 0, high = n - 1;

  while(mid <= high){
   if(a[mid] <= a[low]){
   	int temp = a[mid];
   	a[mid] = a[low];
   	a[low] = temp;
   	low++;mid++;
   }
   else if(a[mid] <= a[high]){
   	mid++;
   }
   else if(a[mid] > a[high]){
    int temp = a[mid];
    a[mid] = a[high];
    a[high] = temp;
    high--;	
   }	
  }

  for(int i = 0; i < n; i++)
  	System.out.print(a[i] + " ");
 }	
}