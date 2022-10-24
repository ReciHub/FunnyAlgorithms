/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

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
