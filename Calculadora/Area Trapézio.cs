using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AreaTrapezio
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Digite a Base menor do trapézio");
            int basemenor = int.Parse(Console.ReadLine());

            Console.WriteLine("Digite a Base maior do trapézio");
            int basemaior = int.Parse(Console.ReadLine());

            Console.WriteLine("Digite a Altura do trapézio");
            int altura = int.Parse(Console.ReadLine());

            int calculo1 = basemenor + basemaior;
            int calculo2 = calculo1 * altura;
            int resultado = calculo2 / 2;

            Console.WriteLine("A área do trapézio é: " + resultado);
        }
    }
}
