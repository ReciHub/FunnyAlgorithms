using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Perímetro_e_Área_do_quadrado
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Informe o valor de um lado do quadrado");
            int lado = int.Parse(Console.ReadLine());

            int perimetro = lado * 4;
            int area = lado * lado;

            Console.WriteLine("A área do quadrado é: "+ area);
            Console.WriteLine("O perímetro do quadrado é: "+ perimetro);
        }
    }
}
