using System;
using System.Threading;

namespace testeCSharp
{
    class Program
    {
        static void Main(string[] args){

            System.Console.WriteLine("You have to guess the number that lies between 1 and 100. \nIf you guess right... you win, else you loose. You have 5 tries.");
            System.Console.Write("Do you want to play? (y to continue or any other key to close)");
            ConsoleKeyInfo lastKeyInfo = Console.ReadKey(true);
            if (lastKeyInfo.Key == ConsoleKey.Y) NumberGuess();
            else Console.Clear();

        }

        static void NumberGuess(){

            System.Console.WriteLine("\nStarting Game...");
            Thread.Sleep(1500); Console.Clear();
        
            Random rnd = new Random();
            int num = rnd.Next(1, 100);
            int chance = 0;

            string distanceNumber;

            while(chance <= 5){
                
                if(chance == 5) {
                    
                    System.Console.WriteLine("You Lose... The number is {0}.", num);
                    chance++; Thread.Sleep(2000);

                }
                else {
                
                    System.Console.Write("Guess The Number: ");
                    int numberAttempt = int.Parse(Console.ReadLine());
                    if(numberAttempt == num){
                    
                        System.Console.WriteLine("You Win!");
                        Thread.Sleep(3000); break;

                    } else {

                        distanceNumber = numberAttempt > num ? "Lower this time." : "Taller this time.";
                        string cc = chance > 1 ? "chance" : "chances";
                        System.Console.WriteLine("Try Again..." + distanceNumber);
                        System.Console.WriteLine("Remains {0} {1}.", 4 - chance, cc);
                        chance++; Thread.Sleep(3000);
                        Console.Clear();

                    }
                }

            }
            
            Console.Clear(); Console.Write("."); Thread.Sleep(1000);
            Console.Clear(); Console.Write(".."); Thread.Sleep(1000);
            Console.Clear(); Console.Write("..."); Thread.Sleep(1000);
            
            Console.Clear(); System.Console.Write("Do You Wanna Play Again? (y to continue or any other key to close)");
            ConsoleKeyInfo lastKeyInfo = Console.ReadKey(true);
            if (lastKeyInfo.Key == ConsoleKey.Y) NumberGuess();
            else Console.Clear();

        }
        
    }
}