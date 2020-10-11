using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication15
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("digite a força");
            int forca = int.Parse(Console.ReadLine());
            Console.WriteLine("digite o espaço");
            int espaco = int.Parse(Console.ReadLine());
            Console.Clear();
            Console.WriteLine("A pressão é: {0}", forca/espaco);
        }
    }
}
