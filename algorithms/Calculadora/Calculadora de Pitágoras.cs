using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculadora_Pitagoras
{
    class Program
    {
        static void Main(string[] args)
        {
            double a, b;

            Console.Write("a: ");
            a = double.Parse(Console.ReadLine());

            Console.Write("b: ");
            b = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine(Pitagoras(a: a, b: b));
            Console.ReadLine();
        }

        public static double Pitagoras(double a, double b)
        {
            double resultado = Math.Sqrt(Math.Pow(a, 2) + Math.Pow(b, 2));
            return resultado;
        }
    }
}
