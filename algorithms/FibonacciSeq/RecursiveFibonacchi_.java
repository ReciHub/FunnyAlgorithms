
package recursivefibonacchi;
import java.util.Scanner;

public class RecursiveFibonacchi {
    public static final Scanner input = new Scanner(System.in);
   
    public static void main(String[] args) {
        long result = 1, previous = 0, num, answer;
        System.out.print("Insert a number: ");
        num = input.nextLong();
        for (int i = 2; i <= num; i++) {
            if (i < 2) {
            	System.out.println(num);
            }
            result = result + previous;
            previous = result - previous;
            answer = result;
            System.out.println(answer);
        }
    }
    
}
