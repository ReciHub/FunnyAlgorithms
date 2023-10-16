import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void funnySort(ArrayList<Integer> arr) {
        System.out.println("Shuffling array using the 'Random Shuffle' algorithm...");
        Collections.shuffle(arr);
        System.out.println("Oops! Array shuffled, but not really sorted! 😄");
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(5);
        arr.add(2);
        arr.add(8);
        arr.add(1);
        arr.add(3);

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        funnySort(arr);

        System.out.print("Shuffled array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}