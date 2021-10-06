using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());

            int cont = 2;
            int result = 1;

            for (int i = 1; i <= num1 || i <= num2; i++)
            {
                if (i == 1)
                {
                    continue;
                }
                else if (num1 % i == 0 && num2 % i == 0)
                {
                    num1 /= i;
                    num2 /= i;
                    result *= i;
                    i--;
                }
            }
            int MDC = result;
            int mmc = num1 * num2 / MDC;
            
            Console.WriteLine("O MDC é " + MDC);
            Console.WriteLine("Já o mmc é \n" + mmc);
        }
    }
}


