using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace calometria
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Digite a massa do corpo: ");
            int massa = int.Parse(Console.ReadLine());
            Console.WriteLine("Digite o calor específico da substância que constitui o corpo: ");
            int calorEspecifico = int.Parse(Console.ReadLine());
            Console.WriteLine("Digite a Temperatura inicial:");
            int tempInicial = int.Parse(Console.ReadLine());
            Console.WriteLine("Digite a Temperatura Final:");
            int tempFinal = int.Parse(Console.ReadLine());
            Console.Clear();
            int VarDeTemp = tempFinal - tempInicial;
            Console.WriteLine("A calorimetria é: {0}", massa * calorEspecifico * VarDeTemp);
            Console.ReadLine();

        }
    }
}
