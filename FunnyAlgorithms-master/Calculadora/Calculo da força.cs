using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication13
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Força");
            int palavra = int.Parse(Console.ReadLine());
            Console.WriteLine("Massa");
            int indice = int.Parse(Console.ReadLine());
            Console.WriteLine("A força é: {0}", palavra * indice); 
        }
    }
}
