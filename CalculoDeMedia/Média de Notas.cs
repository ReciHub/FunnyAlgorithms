using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;

namespace CSharp_Shell
{

    public static class Program 
    {
        public static void Main()
        {
        double contador = 0;
        double divisorMedia = 0;
        double notaMedia = 0;
        Console.WriteLine("Diga o Nome do Aluno:");
        string nome = Console.ReadLine();
        while(contador < 4)
        {
        contador++;
        Console.WriteLine("Digite a nota " + contador + " :");
        double nota = double.Parse(Console.ReadLine());
        if (nota >= 0)
        {
            divisorMedia++;
            notaMedia = notaMedia + nota;
        }
        }
        double media = notaMedia / divisorMedia;
        Console.WriteLine("A Média de " + nome + " é " + media + ".");
        Console.ReadLine();
        }
    }
}