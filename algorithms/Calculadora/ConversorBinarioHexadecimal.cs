using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace raizQuadrada
{
    class Program
    {
        const float pi = 3.141592f;
        static string conversorDeBinario(string binario)
        {
            string palavraHEX = "";
            if(binario == "0000")
            {
                palavraHEX = "0";
            }
            else if(binario == "0001")
            {
                palavraHEX = "1";
            }
            else if(binario == "0010")
            {
                palavraHEX = "2";
            }
            else if(binario == "0011")
            {
                palavraHEX = "3";
            }
            else if(binario == "0100")
            {
                palavraHEX = "4";
            }
            else if(binario == "0101")
            {
                palavraHEX = "5";
            }
            else if(binario == "0110")
            {
                palavraHEX = "6";
            }
            else if(binario == "0111")
            {
                palavraHEX = "7";
            }
            else if(binario == "1000")
            {
                palavraHEX = "8";
            }
            else if(binario == "1001")
            {
                palavraHEX = "9";
            }
            else if(binario == "1010")
            {
                palavraHEX = "A";
            }
            else if(binario == "1011")
            {
                palavraHEX = "B";
            }
            else if(binario == "1100")
            {
                palavraHEX = "C";
            }
            else if(binario == "1101")
            {
                palavraHEX = "D";
            }
            else if(binario == "1110")
            {
                palavraHEX = "E";
            }
            else if(binario == "1111")
            {
                palavraHEX = "F";
            }
            return palavraHEX;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Escreva seu binario");
            string binario = Console.ReadLine();
            Console.WriteLine("Seu binário convertido: {0}{1}", conversorDeBinario(binario.Substring(0,4)), conversorDeBinario(binario.Substring(4,4)));
        }
    }
}
