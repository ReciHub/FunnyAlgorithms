using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp10
{
    class Program
    {
        static void Main(string[] args)
        {
            int cont = int.Parse(Console.ReadLine()) - 1;
            bool entrar = false;
            char[,] matriz = new char[cont, cont];
            for (int i = 0; i < cont; i++)
            {   
                for (int j = 0; j < cont; j++)
                {
                    if(i == 0 || i == cont - 1 || j == 0 || j == cont - 1 || i == j || i + j == cont - 1)
                    {
                        matriz[i, j] = 'x';
                    }
                    else
                    { 
                        matriz[i, j] = ' ';
                    }
                    Console.Write(matriz[i,j]);
                }
                Console.WriteLine();
            }
        }
    }
}
