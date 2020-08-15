using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication14
{
    class Program
    {
        static void Main(string[] args)
        { 
            Console.WriteLine("o primeiro valor que irá multiplicar");
            int valor = int.Parse(Console.ReadLine());
            Console.WriteLine("o segundo valor que irá multiplicar");
            int valor2 = int.Parse(Console.ReadLine());
            Console.WriteLine("o ultimo valor");
            int valor3 = int.Parse(Console.ReadLine());
            Console.Clear();
            Console.WriteLine("o resultado é: {0}", (valor*valor2)/valor3);
        }
    }
}
