/******************************************************************************


While the list is not sorted, snap half of all items (remove them from the list). 
Continue until the list is sorted or only one item remains (which is sorted by default)

*******************************************************************************/
import java.util.Random;

public class Main {

    static int[] thanosAway(int[] citizens, int wrongPlaceWrongTime) {
        int[] survivors = new int[citizens.length -1];
        int index = 0;
        for(int i = 0; i < citizens.length; i++){
            if(i != wrongPlaceWrongTime){
                survivors[index] = citizens[i];
                index++;
            }
        }
        return survivors;
    }

    static Boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    static int[] snap(int[] citizens) {
        Random generator = new Random();

        while (!isSorted(citizens)) {

            int halfLength = citizens.length / 2;

           
            for(int i = 0; i < halfLength; i++){
                int random = generator.nextInt(citizens.length);
                citizens = thanosAway(citizens, random);
            }

            System.out.println("\nSNAP!\n");

            for (int i : citizens) {
                System.out.print(i + " ");
            }
        }

        return citizens;
    }

    public static void main(String[] args) {
        int[] citizens = {10,11,13,3,5,7,8,9,0,11,12,43};
        
        for (int i : citizens) {
            System.out.print(i + " ");
        }

        citizens = snap(citizens);
        System.out.println("\nNo. of survivors "+citizens.length);
    }

}

