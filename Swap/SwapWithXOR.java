package d1;

import java.util.Scanner;

public class SwapWithXOR {

	public static void main(String[] args) {

		int num1, num2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number:");
        num1 = scanner.nextInt();
        System.out.print("Enter second number:");
        num2 = scanner.nextInt();
        System.out.println();
        scanner.close();
        
        System.out.println("The First number before swapping: " + num1);
        System.out.println("The Second number before swapping: " + num2 + "\n");
        
        //num1 becomes 1111 = 15
        num1 = num1 ^ num2;
        //num2 becomes 1010 = 10
        num2 = num1 ^ num2;
        //num1 becomes 0101 = 5
        num1 = num1 ^ num2;
        
        System.out.println("The First number after swapping:"+num1);
        System.out.println("The Second number after swapping:"+num2);

	}

}
