using System;

namespace areaDoCemiCirculo
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("informe o raio")
            int r = int.Parse(Console.ReadLine());
            Console.Clear();
            Console.WriteLine("a área do seu semicirculo é: {0}", (3.14 *(r * r))/2);
        }    
    }
}