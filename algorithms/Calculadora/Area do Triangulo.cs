using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            float d1 = float.Parse(Console.ReadLine());
            float d2 = float.Parse(Console.ReadLine());
            double areaDoTriangulo = d1 * d2 / 2;
            Console.WriteLine(areaDoTriangulo);

        }
    }
}
