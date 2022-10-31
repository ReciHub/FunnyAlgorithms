import java.util.Scanner;

public class WeirdnessChecker {
  static Scanner scanner1 = new Scanner(System.in);

	public static void main(String[] args) {
		Boolean game_in_progress = true;
    
		while (game_in_progress) {
			System.out.println("Do you eat kitkats in one big bite or in pieces?");
			System.out.println("(Type in '1' for one big bite or '2' for pieces)");
			int kitkat_choice = scanner1.nextInt();
		
			if (kitkat_choice == 1) {
				System.out.println("You are weird.");
				game_in_progress = false;
			} else if (kitkat_choice == 2) {
				  System.out.println("You are normal... so far.");
				  System.out.println("Do you pour the milk first or the cereal?");
				  System.out.println("(Type in '1' for milk or '2' for cereal)");
				  int breakfast_choice = scanner1.nextInt();
				
			  	if (breakfast_choice == 1) {
				  	System.out.println("You are weird");
					  game_in_progress = false;
				  } else if (breakfast_choice == 2) {
					  System.out.println("OK... you are still normal...");
					  System.out.println("Do you chomp out a whole bite of a string cheese stick or do you peel individual strings off and eat them?");
					  System.out.println("(Type in '1' for the first option or '2' for the second one)");

					  int cheese_choice = scanner1.nextInt();
					
					  if (cheese_choice == 1) {
  						System.out.println("Nope. You're weird.");
	  					game_in_progress = false;
		  			} else if (cheese_choice == 2) {
			  			System.out.println("You made it! Congratulations, you're not weird.");
				  		game_in_progress = false;
					  } else {
						  System.out.println("Invalid Input. Restart");
						  System.out.println("");
					  }
					
				} else {
					System.out.println("Invalid Input. Restart");
					System.out.println("");
				}
				
			} else {
				System.out.println("Invalid Input. Restart");
			}
		}
	}
}
