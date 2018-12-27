import java.util.Scanner;

class SumOfNumbers{

	public static int sum_of_numbers_iterative(int n){
	    int the_sum = 0;

	    for(int i=0; i<=n; i++)
	        the_sum += i;

	    return the_sum;
	}

	public static void main(String args[]){

		int n;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a number: ");
		n = in.nextInt();

		System.out.println(sum_of_numbers_iterative(n));  //5+4+3+2+1 = 15
	}
}
