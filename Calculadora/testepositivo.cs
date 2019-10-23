using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp17
{
    class Program
    {
        static bool TestePositivo(int a)
        {
            if (a >= 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

            static void Main(string[] args)
        {
            Console.WriteLine("Insira um número para verificar se é positivo ou não");
            int a = int.Parse(Console.ReadLine());
            TestePositivo(a);
            if (TestePositivo(a))
            {
                Console.WriteLine("É positivo");
            }
            else
            {
                Console.WriteLine("Não é positivo");
            }

        }
    }
}
