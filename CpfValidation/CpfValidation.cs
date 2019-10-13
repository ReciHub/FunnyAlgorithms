using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace COISAALEATORIA
{
    class Program
    {
        static void Main(string[] args)
        {
            int resto1 = 0;
            int soma = 0;
            int cont = 10;
            int index = 0;
            Console.WriteLine("Digite seu cpf: ");
            string input = Console.ReadLine();
            char[] numeros = input.Substring(0, 9).ToCharArray();
            foreach (var x in numeros)
            {
                soma += (int.Parse(x.ToString()) * cont);
                cont--;
            }
            foreach (var item in numeros)
            {
                if(item == numeros[0])
                {
                    index = 1;
                }
                else
                {
                    index = 0;
                    break;
                }
            }
            resto1 = MultDiv(soma);
            if (resto1 >= 10 ? 0 == int.Parse(input[9].ToString()) : resto1 == int.Parse(input[9].ToString()) && input.Length < 11)
            {
                soma = 0;
                cont = 11;
                numeros = input.Substring(0, 10).ToCharArray();
                foreach (var item in numeros)
                {
                    soma += (int.Parse(item.ToString()) * cont);
                    cont--;
                }
                int resto2 = MultDiv(soma);
                if(resto2 >= 10 ? 0 == int.Parse(input[10].ToString()) : resto2 == int.Parse(input[10].ToString()) && index == 0)
                {
                    Console.WriteLine("CPF Valido! ");
                }
                else
                {
                    Console.WriteLine("CPF Invalido!  ");
                }
            }
            else
            {
                Console.WriteLine("CPF Invalido!  ");
            }
        }
        public static int MultDiv(int soma)
        {
            return (soma * 10) % 11;
        }
    }
}
