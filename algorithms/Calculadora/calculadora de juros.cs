using System;

namespace RPG_DE_CONSOLE
{
    class Program
    {
        static void Main(string[] args)
        {
           Console.WriteLine("###Calculadora de Juros Simples###");
           Console.WriteLine("Digite o valor do capital:");
           int capital = int.Parse(Console.ReadLine());
           Console.WriteLine("Digite o valor do índice:");
            int indice = int.Parse(Console.ReadLine());
           Console.WriteLine("Digite o tempo:");
            int tempo = int.Parse(Console.ReadLine());
           int juros = capital * indice * tempo;
           Console.WriteLine("O resultado é: {0}", juros );
        }
    }
}
