import java.util.*;
public class FibonacciRecursion {  
    static int n1=0,n2=1,n3=0;      
     static void fibonacciSeries(int count){      
        if(count>0){      
             n3 = n1 + n2;      
             n1 = n2;      
             n2 = n3;      
             System.out.print(" "+n3);     
             fibonacciSeries(count-1);      
         }      
     }        
  
public static void main(String[] args) {  
    Scanner scanner = new Scanner(System.in);
    int count=0;
    System.out.print("Enter number: ");
    count = scanner.nextInt();
    System.out.print(n1+" "+n2);     
    fibonacciSeries(count-2);     
}  
}  