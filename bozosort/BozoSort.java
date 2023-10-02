import java.util.Arrays;
import java.util.Random;

public class BozoSort {

    public static void main(String[] args) {
        int[] myArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] sortedArray = bozoSort(myArray);
        
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    public static int[] bozoSort(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int runs = 0;

        while (!arrayEquals(arr, copy)) {
            int index1 = new Random().nextInt(arr.length);
            int index2 = new Random().nextInt(arr.length);

            int temp = copy[index1];
            copy[index1] = copy[index2];
            copy[index2] = temp;

            runs += 1;
        }

        System.out.println("It took " + runs + " runs to sort the array!");
        return copy;
    }

    public static boolean arrayEquals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}
