using System;

namespace RPG_DE_CONSOLE
{
    class Program
    {
        static void Main(string[] args)
        {
            //An = a1 + (n-1) * r;
            Console.WriteLine("###Calculadora de Progressão Aritmética###");       
            Console.WriteLine("Qual é o primeiro termo dessa PA? ");
            int a1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Qual é a razão: ");
            int razao = int.Parse(Console.ReadLine());
            Console.WriteLine("Qual é o termo que você quer encontrar?");
            int n = int.Parse(Console.ReadLine());
            int result = a1 + ((n-1) * razao);
            Console.WriteLine("O valor do termo que você quer encontrar é: {0} ", result);
            Console.ReadLine();
        }
    }
}
