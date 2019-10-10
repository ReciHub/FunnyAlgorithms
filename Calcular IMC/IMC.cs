using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calcular_trabalho
{
    class Program
    {
        static void Main(string[] args)
        {
            double a, b, IMC;
            Console.Write("Digite seu peso: ");
            a = double.Parse(Console.ReadLine());
            Console.Write("Digite sua altura: ");
            b = double.Parse(Console.ReadLine());
            IMC = Math.Round(a / (Math.Pow(b, 2)), 2);
            Console.WriteLine("Seu IMC é: {0}", IMC);

            if (IMC < 16)
            {
                Console.ForegroundColor = ConsoleColor.DarkRed;
                Console.WriteLine("Seu estado é de Subpeso severo");
            }
            else if (IMC >= 16 && IMC <= 19.9)
            {
                Console.ForegroundColor = ConsoleColor.DarkYellow;
                Console.WriteLine("Seu estado é de Subpeso");
            }
            else if (IMC >= 20 && IMC <= 24.9)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("Seu estado é Normal");
            }
            else if (IMC >= 25 && IMC <= 29.9)
            {
                Console.WriteLine("Seu estado é de Sobrepeso");
            }
            else if (IMC >= 30 && IMC <= 39.9)
            {
                Console.ForegroundColor = ConsoleColor.DarkYellow;
                Console.WriteLine("Seu estado é de Obesidade");
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.DarkRed;
                Console.WriteLine("Seu estado é de Obesidade morbida");
            }
            
            Console.ReadKey();
        }
    }
}
