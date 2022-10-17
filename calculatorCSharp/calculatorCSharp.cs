using System;
					
public class Program
{
	public static void Main()
	{
	    //Variables

        double numberOne, numberTwo;
        int result = 0;

        //body

        Console.Write("If you just want to make a square root, enter zero in the second number that we will request.");

        Console.WriteLine("Please enter a number.");
        numberOne = double.Parse(Console.ReadLine());

        Console.WriteLine("Enter another number.");
        numberTwo = double.Parse(Console.ReadLine());

        Console.Clear();

        //process

        while (result != 6)

            {

                Console.WriteLine("To add, type 1.");

                Console.WriteLine("To subtract, type 2.");

                Console.WriteLine("To divide, type 3.");

                Console.WriteLine("Para multiplicar digite 4");

                Console.WriteLine("To multiply, type 4.");

                Console.WriteLine("To square root, type 5.");

                Console.WriteLine("To exit, type 6.");

                result = int.Parse(Console.ReadLine());

                if (result == 1)
                {
                    Console.WriteLine("Addition = {0}", numberOne + numberTwo);
                }
                 else if (result == 2)
                {
                    Console.WriteLine("Subtraction = {0}", numberOne - numberTwo);
                }
                else if (result == 3)
                {
                    Console.WriteLine("Division = {0}", numberOne / numberTwo);
                }
                else if (result == 4)
                {
                    Console.WriteLine("Multiplication = {0}", numberOne * numberTwo);
                }
                else if (result == 5)
                {
                    Console.WriteLine("Square Root = {0}", Math.Round(Math.Sqrt(numberOne)));
                }

                Console.ReadLine();

                Console.Clear();

            }
	}
}