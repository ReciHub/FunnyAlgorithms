using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fatorial
{
    class Program
    {
        static int fatorial(int a)
        {
            int result = 0;
            if (a == 0)
            {
                return 1;
            }
            else if (a == 1)
            {
                return a;
            }
            else
            {
                return a * fatorial(a - 1);
            }
            return 0;


        }
        static void Main(string[] args)
        {
            Console.Title = "Fatorial";
            Console.WriteLine("Digite um numero que você quer ver o fatorial:");
            int fator = int.Parse(Console.ReadLine());
            Console.WriteLine("O fatorial do seu numero é " + fatorial(fator));
            Console.ReadKey();
        }

    }
}
