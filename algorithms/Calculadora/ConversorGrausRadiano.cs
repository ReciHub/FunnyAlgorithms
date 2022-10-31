using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace raizQuadrada
{
    class Program
    {
        const float pi = 3.141592f;
        static float converter(float graus)
        {

            return (graus * pi) / 180;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Quantos graus você quer converter?");
            float graus = float.Parse(Console.ReadLine());
            Console.WriteLine("O valor em radianos é: {0}", converter(graus));
        }
    }
}
