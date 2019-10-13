using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Velocidade_Média
{
    class Program
    {
        static void Main(string[] args)
        {
            double dUm, dDois, tempoUm, tempoDois;

            Console.Write("Posição Inicial: ");
            dUm = double.Parse(Console.ReadLine());

            Console.Write("Posição Final: ");
            dDois = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.Write("Tempo Inicial: ");
            tempoUm = double.Parse(Console.ReadLine());

            Console.Write("Tempo Final: ");
            tempoDois = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine(Velocidade(dUm: dUm, dDois: dDois, tempoUm: tempoUm, tempoDois: tempoDois));
            Console.ReadLine();
        }

        public static double Velocidade(double dUm, double dDois, double tempoUm, double tempoDois)
        {
            double resultado = (dDois - dUm) / (tempoDois - tempoUm);
            return resultado;
        }
    }
}
