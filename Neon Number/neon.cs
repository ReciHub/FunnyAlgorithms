using System;

namespace ConsoleApp
{
    public class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the number: ");
            var inputNumber = Console.ReadLine();
            if (int.TryParse(inputNumber, out int number))
            {
                Console.WriteLine(IsNeonNumber(Convert.ToInt32(number)));
            }
            else
            {
                Console.WriteLine("Please enter numeric value.");
            }
            Console.ReadLine();
        }

        static string IsNeonNumber(int x)
        {
            // storing the square of x 
            int square = x * x;

            // calculating the sum of digits of square
            int sumOfDigits = 0;
            while (square != 0)
            {
                sumOfDigits += square % 10;
                square /= 10;
            }

            return $"{x} is " + ((sumOfDigits == x) ? string.Empty : "not ") + "neon number";
        }
    }
}
