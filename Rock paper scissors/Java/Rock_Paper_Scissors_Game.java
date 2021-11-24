import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors_Game {

	public static void main(String[] args) {
		while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("Do you choose rock, paper or scissors? To quit the game, enter \"q\"");
			String userChoice = s.nextLine();
			
			if(userChoice.equals("q")) {
				break;
			}

			if(!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
				System.out.println("Invalid input. Please enter one of rock, paper or scissors");			
			} else {

				int com = (int) (Math.random() * 3) + 1; // 0.0~1.0
				System.out.println(com);

				String computerChoice = "";
				if (com == 1) {
					computerChoice = "rock";
				} else if (com == 2) {
					computerChoice = "paper";
				} else {
					computerChoice = "scissors";
				}

				System.out.println("Computer: " + computerChoice);
		
					
				//Print the results of the game: tie, lose, win
				if(userChoice.equals(computerChoice)) {
					System.out.println("It's a tie!");
				} else if((userChoice.equals("rock") && computerChoice.equals("scissors")) || (userChoice.equals("scissors") && computerChoice.equals("paper")) || (userChoice.equals("paper") && computerChoice.equals("rock"))) {
					System.out.println(">> User Wins!!");
				} else {
					System.out.println(">> Computer Wins!");
				}
				
			}
			
		}
		
	}

}