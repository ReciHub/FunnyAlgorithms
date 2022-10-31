using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace ConsoleApp27
{
    class Program
    {
        static void Main(string[] args)
        {
            IniciarCalculo();
        }

        public static void IniciarCalculo()
        {
            Console.Clear();
             
            Console.WriteLine("Pressão, pode ser definida como a intensidade de uma força atuante F numa determinada área S. \nOu seja, para acharmos a pressão devemos dividir a força exercida pela área");
            Console.Write("\nSe deseja calcular pressão, digite 0. \nSe quiser calcular a força exercida, digite 1. \nE se desejar calcular a área, digite 2 \nSua escolha: ");
            int choose = int.Parse(Console.ReadLine());

            if      (choose == 0) CalcularPressao();
            else if (choose == 1) CalcularForcaExercida();
            else if (choose == 2) CalcularArea();
            else
            {
                Console.WriteLine("Você não selecionou uma opção válida. Por favor, tente novamente.");
                Thread.Sleep(2000);
                Console.Clear();

                Console.WriteLine(".");
                Thread.Sleep(500);
                Console.WriteLine("..");
                Thread.Sleep(500);
                Console.WriteLine("...");
                Thread.Sleep(500);

                IniciarCalculo();
            }
        }

        public static float CalcularPressao()
        {
            Console.Clear();

            int result;

            Console.Write("Digite a força exercida: ");
            int a = int.Parse(Console.ReadLine());

            Console.Write("Digite a área: ");
            int b = int.Parse(Console.ReadLine());

            result = a / b;

            return result;
        }

        public static float CalcularForcaExercida()
        {
            Console.Clear();

            int result;

            Console.Write("Digite a pressão: ");
            int a = int.Parse(Console.ReadLine());

            Console.Write("Digite a área: ");
            int b = int.Parse(Console.ReadLine());

            result = a * b;

            return result;
        }

        public static float CalcularArea()
        {
            Console.Clear();

            int result;

            Console.Write("Digite a força exercida: ");
            int a = int.Parse(Console.ReadLine());

            Console.Write("Digite a pressão: ");
            int b = int.Parse(Console.ReadLine());

            result = a / b;

            return result;
        }
    }
}
