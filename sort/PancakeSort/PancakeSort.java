import java.util.Arrays;

public class PancakeSort {

    private static void flip(int[] arr, int t) {
        int prev;

        for (int i = 0; i <= t/2; i++) {
            prev = arr[i];
            arr[i] = arr[t-i];
            arr[t-i] = prev;
        }
    }

    private static int getMaxIndex(int[] arr, int t) {
        int max = arr[0], maxIndex = 0;

        for (int i = 1; i < t; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void pancakeSort(int[] arr) {
        for (int i = arr.length; i > 1; i--) {
            int maxIndex = getMaxIndex(arr, i);

            flip(arr, maxIndex);
            flip(arr, i - 1); 
        }
    }
    public static void main(String args []) {
        int[] arr = { 10, 4, -1, 4, 0, 2, 6, 1, 7 };

        pancakeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}