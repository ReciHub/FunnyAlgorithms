import java.util.Scanner;

class Main{

	public static int sum_of_natural_numbers(int n){
	    int sum = 0;

      sum = (n * (n+1)) /2 ;

	    return sum;
	}

	public static void main(String args[]){

		int n;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number: ");
		n = in.nextInt();

		System.out.println(sum_of_natural_numbers(n));  //3+2+1 = 6
	}
}
