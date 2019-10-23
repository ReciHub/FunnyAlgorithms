using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp15
{
    class Program
    {
        static void Main(string[] args)
        {
            

            
            int[,] A = new int[2, 2] { {2, 3} ,
                                       {4, 5}};
            int[,] B = new int[2, 2] { {2, 3} ,
                                       {4, 5}};
            int[,] C = new int[2, 2];
            int aux = 0;
            for (int i = 0; i < A.GetLength(0); i++)
            {
                for (int j = 0; j < A.GetLength(1); j++)
                {

                    Console.WriteLine(C[i, j] = A[i, j] + B[i, j]);
                }
            }
            
            



        }
    }
}
