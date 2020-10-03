import java.util.Scanner;
 
class ArmstrongNumber
{
   public static void main(String args[])
   {
      int sum = 0, temp, remainder, digits = 0;
 
      InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);
      System.out.println("Input a number to check if it is an Armstrong number");      
      String n = Integer.parseInt();
 
      temp = n;
     
      // Count number of digits
     
      while (temp != 0) {
         digits++;
         temp = temp/10;
      }
 
      temp = n;
 
      while (temp != 0) {
         remainder = temp%10;
         sum = sum + power(remainder, digits);
         temp = temp/10;
      }
 
      if (n == sum)
         System.out.println(n + " is an Armstrong number.");
      else
         System.out.println(n + " isn't an Armstrong number.");        
   }
   
   static int power(int n, int r) {
      int c, p = 1;
 
      for (c = 1; c <= r; c++)
         p = p*n;
 
      return p;  
   }
}
