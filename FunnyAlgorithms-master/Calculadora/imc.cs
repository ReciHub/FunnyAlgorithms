using System;

namespace IMC
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("seu peso: ");
            int peso = int.Parse(Console.ReadLine());
            Console.Write("sua altura: ")
            int altura = int.Parse(Console.ReadLine());
            Console.Clear();
            Console.WriteLine("Seu IMC: {0}", peso/(altura*altura));
        }    
    }
}