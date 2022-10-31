using System;
using System.Threading;

namespace testeCSharp
{
    class Program
    {
        static void Main(string[] args){


            //Example of use
            int[] numbers = {0, 11, 24, 139, 150, 547};
            
            Console.WriteLine(PrimeChecker(numbers[0]));
            //false

            Console.WriteLine(PrimeChecker(numbers[1]));
            //true

            Console.WriteLine(PrimeChecker(numbers[2]));
            //false

            Console.WriteLine(PrimeChecker(numbers[3]));
            //true

            Console.WriteLine(PrimeChecker(numbers[4]));
            //false

            Console.WriteLine(PrimeChecker(numbers[5]));
            //true

        }

        static bool PrimeChecker(int number){
            
            if(number == 1 || number == 0) return false;
            else {

                for (int i = 2; i < number; i++)
                {
                    
                    if(number % i == 0) return false;

                }

            }

            return true;

        }
        
    }

}