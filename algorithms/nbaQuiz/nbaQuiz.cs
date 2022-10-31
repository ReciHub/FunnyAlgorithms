using System;
					
public class Program
{
	public static void Main()
	{
		//Variables

        string responseOne = "";
        string responseTwo = "";
        string responseThree = "";
        int score = 0;
        Console.Clear();

        //Body

        Console.Write("Welcome to the NBA quiz! Let's see if you are a real hooper!");
        Console.WriteLine("But before you start, tell me your name.");
        string nameUser = Console.ReadLine();

        Console.Write("1° - {0}, who is the player with the most career points in NBA history?", nameUser);
        Console.WriteLine("Enter 1 for Kareem Abdul-Jabbar / Enter 2 for Lebron James / Enter 3 for Michael Jordan");
        responseOne = Console.ReadLine();

        if (responseOne == "1" ) {
        score++;
        Console.Write("Congratulations {0}, you are correct, let's go to the next question.", nameUser);
        }
        else {
        Console.Write("{0}, you missed the first one but don't get discouraged, there are still other chances.", nameUser);
        }

        Console.Write("2° - {0}, who has the highest average number of assists per game in NBA history?", nameUser);
        Console.WriteLine("Enter 1 for John Stockton / Enter 2 for Magic Johnson / Enter 3 for Steve Nash");
        responseTwo = Console.ReadLine();

        if (responseTwo == "2" ) {
        score++;
        Console.Write("Congratulations {0}, you are correct, Magic was a commander on the court, those assists were incredible, let's go to the next question!", nameUser);
        }
        else {
        Console.Write("{0}, you missed. No comments.", nameUser);
        }

        Console.Write("3° - {0}, Who is the GOAT? GOAT = Greatest Of All Times", nameUser);
        Console.WriteLine("Enter 1 for Michael Jordan / Enter 2 for Brian Scalabrini / Enter 3 for Kobe Bryant");
        responseThree = Console.ReadLine();

        if (responseThree == "1" ) {
        score++;
        Console.Write("Congratulations {0}, Jordan is just Jordan. Everyone wants to be like Mike.", nameUser);
        }
        else {
        Console.Write("{0}, you were wrong and this was very easy. You are kidding with me?", nameUser);
        }

        //Conclusion

        Console.Write("We have reached the end of this short quiz, I hope you had fun. Now let's see your score.");

        if (score == 3) {
        Console.WriteLine("Wow! 3/3, perfect percentage. You're almost a professional basketball analyst! {0} you're on fire!", nameUser);
        }
        else if (score == 2) {
        Console.WriteLine("You got two right. {0}, you did well, but you are still far from being a big fan.", nameUser);
        }
        else if (score == 1) {
        Console.WriteLine("You got one right. {0}, you were really bad. To be honest, I expected more. :/", nameUser);
        }
        else {
        Console.WriteLine("{0}, you didn't get any right, I prefer not to comment on your result, please just end me quickly.", nameUser);
        }


	}
}