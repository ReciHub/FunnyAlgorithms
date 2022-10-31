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
            Console.WriteLine("É Palíndromo? => " + PalindromeChecker(a));

        }



        static bool PalindromeChecker(string words)
        {
            char[] wordArray = words.ToCharArray();
            Array.Reverse(wordArray);
          
            string wordsReverse = new string (wordArray).ToLower();
            string wordsNormal = words.ToLower();

            if(RemoveAccentuation(wordsReverse) == RemoveAccentuation(wordsNormal))
            {
                return true;
            }
                else
            {
                return false;
            }
        }

        private static string RemoveAccentuation(string word)
        {
            word = word.Replace(" ", "");
            word = word.Replace(",", "");
            word = word.Replace(".", "");
            word = word.Replace("-", "");

            word = word.Replace("À", "A");
            word = word.Replace(" ", "A");
            word = word.Replace("Á", "A");
            word = word.Replace("Ã", "A");

            word = word.Replace("à", "a");
            word = word.Replace("â", "a");
            word = word.Replace("á", "a");
            word = word.Replace("ã", "a");

            word = word.Replace("Ê", "E");
            word = word.Replace("É", "E");

            word = word.Replace("ê", "e");
            word = word.Replace("é", "e");

            word = word.Replace("Ó", "O");
            word = word.Replace("Ô", "O");

            word = word.Replace("ó", "o");
            word = word.Replace("ô", "o");

            word = word.Replace("ú", "u");

            return word;
        }
    }
}


