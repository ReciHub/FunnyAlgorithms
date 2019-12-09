using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp20
{
    class VelocidadeDeOnda
    {
        static int VelocidadeDaOnda(int comprimento, int frequencia)
        {
            return comprimento * frequencia;
        }
        static void Main(string[] args)
        {
            Console.Write("Comprimento da onda: ");
            int comprimento = int.Parse(Console.ReadLine());
            Console.Write("Frenquência da onda: ");
            int frequencia = int.Parse(Console.ReadLine());
            Console.Clear();
            Console.WriteLine("A velocidade da onda é: " + VelocidadeDaOnda(comprimento, frequencia) + "m/s");
            Console.ReadKey();
        }
    }
}
