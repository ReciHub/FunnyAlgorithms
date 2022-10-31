import java.util.Scanner;
 
class ArmstrongNumber
{
   public static void main(String args[])
   {
      int sum = 0, temp = 0, remainder = 0, digits = 0;
 
      Scanner sc = new Scanner(System.in);
      System.out.println("Input a number to check if it is an Armstrong number:");      
      Integer n = sc.nextInt();
 
      temp = n;
     
      // Count number of digits
      while (temp != 0) {
         digits++;
         temp = temp/10;
      }
 
      temp = n;
 
      // calculate sum of numbers to the power of digits
      while (temp != 0) {
         remainder = temp % 10;
         sum = sum + power(remainder, digits);
         temp = temp/10;
      }
      
      System.out.printf("%d %s an Armstrong number.\n", n, (sum == n)? "is" : "isn't");  
   }
   
   static int power(int n, int r) {
      int c, p = 1;
 
      for (c = 1; c <= r; c++)
         p = p * n;
 
      return p;  
   }
}
