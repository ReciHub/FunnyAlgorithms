/*
  Author: grabartley
  
  This algorithm is funny because no matter what positive integer it is given, it will always reach 1. Each term is obtained from the previous term as follows: if the previous term is even, the next term is one half the previous term. If the previous term is odd, the next term is 3 times the previous term plus 1.
*/
import java.util.Scanner;

public class Collatz {
  private static void collatz(long num) {
    // when we reach 1, the algorithm is complete
    if (num == 1L) {
      System.out.println("We reached 1!");
    // otherwise change the number based on if it's odd or even and try again
    } else {
      System.out.println(num);
      num = num % 2L == 0L ? num / 2L : (num * 3L) + 1L;
      collatz(num);
    }
  }
  
  public static void main(String[] args) {
    long num = 1L;
    // if we have a command line argument, use it
    if (args.length > 0) {
      try {
        num = Long.parseLong(args[0]);
      } catch (NumberFormatException e) {
        System.err.println("Please enter a valid positive integer!");
        System.exit(1);
      }
    // else read from stdin
    } else {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a positive integer: ");
      num = input.nextLong();
    }
    collatz(num);
  }
}