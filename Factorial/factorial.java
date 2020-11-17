import java.util.Scanner;
class Factorial{

  public static void main(String[] args){
  
    Scanner s=new Scanner(System.in);
    System.out.println("Enter a non negative number");
    int n=s.nextInt();
    int fact=1;
    if(n==0 || n==1){
      fact=1;
    }else{
    
      for(int i=2;i<=n;i++)
      fact*=i;
    }
    System.out.println("Factorial of the number is "+fact);
  }
}
