using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            float d1 = float.Parse(Console.ReadLine());
            float d2 = float.Parse(Console.ReadLine());
            float d3 = float.Parse(Console.ReadLine());
            float areaDoTrapezio = (d1 + d2)*d3 / 2;
            Console.WriteLine(areaDoTrapezio);
       

        }
    }
}
