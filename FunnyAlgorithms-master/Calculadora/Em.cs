using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace E_Mecânica
{
    class Program
    {
        static void Main(string[] args)
        {
            double massa, vel, altura, acelGravi;

            Console.Write("Massa: ");
            massa = double.Parse(Console.ReadLine());

            Console.Write("Velocidade: ");
            vel = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.Write("Altura: ");
            altura = double.Parse(Console.ReadLine());

            Console.Write("Aceleração da Gravidade: ");
            acelGravi = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine("Energia Mecânica = {0}", EC(massa: massa, vel: vel, altura: altura, acelGravi: acelGravi));
            Console.ReadLine();
        }

        public static double EC(double massa, double vel, double altura, double acelGravi)
        {
            double resultado = (massa * acelGravi * altura) + ((massa * Math.Pow(vel, 2)) / 2);
            return resultado;
        }
    }
}
