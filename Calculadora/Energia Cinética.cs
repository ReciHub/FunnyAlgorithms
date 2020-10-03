using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculo_de_EC
{
    class Program
    {
        static void Main(string[] args)
        {
            double massa, vel;

            Console.Write("Massa: ");
            massa = double.Parse(Console.ReadLine());

            Console.Write("Velocidade: ");
            vel = double.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine("Energia Cinética = {0}", EC(massa: massa, vel: vel));
            Console.ReadLine();
        }

        public static double EC(double massa, double vel)
        {
            double resultado = (massa * Math.Pow(vel, 2)) / 2;
            return resultado;
        }
    }
}
