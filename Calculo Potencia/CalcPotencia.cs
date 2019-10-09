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
            double potencia, trabalho, tempo;

            Console.Write("Digite o trabalho em (J) exercido pelo corpo: ");
            trabalho = double.Parse(Console.ReadLine());
            Console.Write("Digite o tempo em (s) que o corpo leva para realizar ação: ");
            tempo = double.Parse(Console.ReadLine());
            potencia = trabalho / tempo;

            Console.WriteLine(potencia);
        }
    }
}
