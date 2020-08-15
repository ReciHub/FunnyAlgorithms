using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CircunferenciaERaio
{
    class Program
    {
        const float pi = 3.14159265359f;
        static float areaDaCircunferencia(float raio)
        {
            return raio*raio*pi;
        }
        static void Main(string[] args)
        {
            float raio;
            Console.Write("Informe o raio da circunferência: ");
            raio = float.Parse(Console.ReadLine());
            Console.Write("A área de sua circunferencia é: ");
            Console.WriteLine(areaDaCircunferencia(raio));
        }
    }
}
