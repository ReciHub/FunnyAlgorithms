import java.util.Scanner;

public class dumbChecker {

	static int input;
	
	public static void main(String[] args) {
		
		int value;
		
		try {
			System.out.print("Enter your lucky number:");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextInt();
		
			int random = (int)(Math.random() * 10 + 1);
			
			//Doesn't matter what user type.percentage also show accourding to random number
			System.out.println("You are "+random*10 +"% dumb!");
			
		}catch(Exception e){
			System.out.println("Run again and enter a number dumbA**");
		}
		
	}

}