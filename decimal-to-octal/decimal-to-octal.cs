using System;

namespace testeCSharp
{
    class Program
    {
        static int i = 1;
        static void Main(string[] args)
        {
            
            Console.Write("Enter a Decimal Number: ");
            int dec = int.Parse(Console.ReadLine());
            
            Console.Write("Octal number is: ");
            int[] oct = Octal(dec);
            
            for (int c = i - 1; c > 0; c--)
            {
                
                Console.Write(oct[c]);

            }

            Console.ReadKey();

        }

        static int[] Octal(int dec){

            int[] a = new int[50];
            while (dec != 0)
            {
                a[i++] = dec % 8;
                dec = dec / 8;
            }
            return a;

        }
    }
}
