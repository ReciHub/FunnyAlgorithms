import java.util.Scanner;


public class factorial2{
  public static long fact(int n){
    if (n<=1){
      return 1;
    }
      return n*fact(n-1);
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number to factorialize: ");
    
    String input = scanner.nextLine();
    int num = Integer.parseInt(input);
    if(num < 0)
      System.out.println("Cannot calculate factorial for negative numbers");
    else
      System.out.printf("The factorial of %d is %d.\n", num, fact(num));
  }
}
