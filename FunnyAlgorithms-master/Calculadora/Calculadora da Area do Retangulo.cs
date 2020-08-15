using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            float base1, altura;
            base1 = float.Parse(Console.ReadLine());
            altura = float.Parse(Console.ReadLine());
            double areaDoRetangulo = base1 * altura;
            Console.WriteLine(areaDoRetangulo);

        }
    }
}
