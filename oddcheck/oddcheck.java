import java.util.Scanner;

public class oddcheck {

    public static void main(String[] args) {
        System.out.println("Please input a number");
		Scanner s = new Scanner(System.in);
		
		int number = s.nextInt();
		
		if(number % 2 == 1) {
			System.out.println(number + " is odd");
		}else {
			System.out.println(number + " is even");
		}
		
	}

}
