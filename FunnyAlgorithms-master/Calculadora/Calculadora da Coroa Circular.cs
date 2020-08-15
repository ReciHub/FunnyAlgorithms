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
            float d1 = float.Parse(Console.ReadLine());
            float d2 = float.Parse(Console.ReadLine());
            double areaDaCoroaCircular = 3.14 *(d1*d1-d2*d2);
            Console.WriteLine(areaDaCoroaCircular);

        }
    }
}
