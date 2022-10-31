import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class provides a methods to determine if a number is even or odd, not the most efficient way to do it,
 * but a way nonetheless.
 */
public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean quit = false;
        while(true) {
            System.out.print("Enter an integer (enter anything besides an integer to quit): ");
            int num = 0;
            try {
                num = input.nextInt();
                num = Math.abs(num);
            }
            catch(InputMismatchException ime) {
                quit = true;
                System.out.println("Goodbye");
            }

            if(quit)
                break;


            if(isEven(num))
                System.out.println(num + " is even");
            else
                System.out.println(num + " is odd");
        }
        
        input.close();
    }

    private static boolean isEven(int num) {
        return isEven(num, true);
    }

    private static boolean isEven(int num, boolean same) {
        if(num == 0)
            return same;
       
        return !isOdd(num-1, !same);
    }

    private static boolean isOdd(int num, boolean same) {
        return !isEven(num, same);
    }
}
