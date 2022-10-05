public class ShellSort
{
    /* An utility function to print array of size n*/
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
     /* function to sort arr using shellSort */
    public int sort(int arr[])
    {
         // Start with a big gap(say k), then reduce the k

        int n = arr.length;
        for (int k = n/2; k > 0; k /= 2)
        {
            // Do a gapped insertion sort for this k size.
            // The first k elements a[0..k-1] are already
            // in gapped order keep adding one more element
            // until the entire array is k sorted
            for (int i = k; i < n; i += 1)
            {
                // add arr[i] to the elements that have been k
                // sorted save arr[i] in temp and make a hole at
                // position i
                int temp = arr[i];
                // shift earlier k-sorted elements up until
                // the correct location for arr[i] is found
                int j;
                for (j = i; j >= k && arr[j - k] > temp; j -= k)
                    arr[j] = arr[j - k];
                
                // put temp (the original arr[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }

    public static void main(String args[])
    {
        int arr[] = {12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        printArray(arr);
  
        ShellSort ob = new ShellSort();
        ob.sort(arr);
  
        System.out.println("Array after sorting");
        printArray(arr);
    }
} 
