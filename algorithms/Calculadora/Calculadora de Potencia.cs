using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace potencia
{
    class Program
    {
        static int aux = 1;
        static int potencia(int Base, int expoente)
        {
            aux *= Base;
            if (Base == 0)
            {
                aux = 0;
            }
            if (expoente == 0)
            {
                aux = 1;
            }
            if (Base == 0 && expoente == 0)
            {
                aux = 0;
            }
            if (expoente == 1)
            {
                return aux;
            }
            if (expoente > 1)
            {
                potencia(Base, expoente - 1);
            }
            return aux;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Valor da base");
            int vBase = int.Parse(Console.ReadLine());
            Console.WriteLine("Valor do expoente");
            int expoente = int.Parse(Console.ReadLine());
            Console.Clear();
            Console.WriteLine("O resultado é: " + potencia(vBase, expoente));
        }
    }
}
