using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace calcular_Raiz_Exata
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Informe o radicando da Raiz Quadrada");
            double Raiz = int.Parse(Console.ReadLine());

            double resultado = Math.Sqrt(Raiz);

            Console.WriteLine("O resultado da Raiz Quadrada é: "+ resultado);
        }
    }
}
