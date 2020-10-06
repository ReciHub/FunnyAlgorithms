import java.util.Random;
import java.util.Scanner;

public class ShuffleSort
{
	private static Random rand = new Random();

	/*
	 * We have to guess the number that lies between 1 and 100. If you guess right...you win, else
	 * you loose. You have 5 tries.
	 */

	private static Scanner scanner = new Scanner(System.in);

	public static void guessNum()
	{
		int num = rand.nextInt(100) + 1;
		int chance = 1;
		while(chance <= 5)
		{
			System.out.print("Guess The Number : ");
			int n = scanner.nextInt();
			if(num == n)
			{
				System.out.println("You Win");
				return;
			}
			else
			{
				chance += 1;
				System.out.println("Try Again");
			}
		}
		System.out.println("You Lose");
	}

	public static void main(String[] args)
	{
		String gamePlay = "y";
		while(gamePlay.equalsIgnoreCase("y"))
		{
			guessNum();
			scanner.nextLine();
			System.out.println("Do You Wanna Play Again?");
			gamePlay = scanner.nextLine();
		}
	}
}
