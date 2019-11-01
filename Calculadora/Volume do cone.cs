using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace volume_do_cone
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Informe o raio do círculo presente no cone");
            int raio = int.Parse(Console.ReadLine());
            Console.WriteLine("Informe a altura do cone");
            int altura = int.Parse(Console.ReadLine());

            int π = 3;

            int calculo1 = raio * raio;
            int calculo2 = π * calculo1;
            int calculo3 = calculo2 * altura;
            int resultado = calculo3 / 3;

            Console.WriteLine("O volume do seu cone é: " + resultado);











        }
    }
}
