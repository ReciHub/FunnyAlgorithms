using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp16
{
    class Program
    {
        static int Md(int b)
        {
            if (b >= 0)
            {
                return b;
            }
            else
            {
                return (b * (-1));
            }
        }
            static void Main(string[] args)
        {
            Console.WriteLine("Insira um número para verificar seu módulo");
            int b = int.Parse(Console.ReadLine());
            Md(b);
            Console.WriteLine(Md(b));

        }
    }
}
