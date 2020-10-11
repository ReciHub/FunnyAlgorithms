using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.Write("Digite uma frase ou palavra: ");
            string a = Console.ReadLine();
            Console.WriteLine("String Reversa: " + ReverseString(a));

        }



        static string ReverseString(string words)
        {
            char[] wordArray = words.ToCharArray();
            Array.Reverse(wordArray);

            string wordsReverse = new string (wordArray);

            return wordsReverse;     
        }
    }
}

