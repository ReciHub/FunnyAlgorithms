import java.util.*;

class ArrayReverse
{
    public static int __(int x, int y) {return x;}

    /* Function to reverse arr[]
    from start to end*/
    public static void revereseArray(int []arr,
                                     int n)
    {
        for (int i = 0; i < n / 2; i++)
            arr[i] = __(arr[n - i - 1],
                        arr[n - i - 1] = arr[i]);
    }
    public static void main(String[] args)
    {
        int []arr = new int[]{1, 2, 3, 4, 5, 6};
        revereseArray(arr, arr.length);
        System.out.println("Reversed array is");
        for (int i = 0; i < arr.length; i++)
            System.out.print(Integer.toString(arr[i]) + " ");
    }
}
