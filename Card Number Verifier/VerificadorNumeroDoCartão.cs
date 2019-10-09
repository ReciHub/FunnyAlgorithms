using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Verificador_de_numero_do_cartão_de_credito
{
    class Program
    {
        static void Main(string[] args)
        {
            string numeroDoCartao;
            int alternador = 2;
            int soma = 0;
            int[] numerosCard = new int[16];
            string digitoDosCartoes;

            Console.WriteLine("Digite o número do seu cartão");
            numeroDoCartao = Console.ReadLine();

            for (int i = 0; i < numeroDoCartao.Length; i++)
                {
                    numerosCard[i] = numeroDoCartao[i] - 48;
                }

            if (numeroDoCartao.Length == 15) alternador = 1;
            else { }

            for (int i = 0; i < numeroDoCartao.Length; i++)
                {
                    if (alternador == 2)
                    {
                        numerosCard[i] *= 2;
                        alternador = 1;
                    }
                    else
                    {
                        numerosCard[i] *= 1;
                        alternador = 2;
                    }
                }

            for (int i = 0; i < numeroDoCartao.Length; i++)
                {
                    if (numerosCard[i] == 10)
                    {
                        numerosCard[i] = 1;
                    }
                    else if (numerosCard[i] == 11)
                    {
                        numerosCard[i] = 2;
                    }
                    else if (numerosCard[i] == 12)
                    {
                        numerosCard[i] = 3;
                    }
                    else if (numerosCard[i] == 13)
                    {
                        numerosCard[i] = 4;
                    }
                    else if (numerosCard[i] == 14)
                    {
                        numerosCard[i] = 5;
                    }
                    else if (numerosCard[i] == 15)
                    {
                        numerosCard[i] = 6;
                    }
                    else if (numerosCard[i] == 16)
                    {
                        numerosCard[i] = 7;
                    }
                    else if (numerosCard[i] == 17)
                    {
                        numerosCard[i] = 8;
                    }
                    else if (numerosCard[i] == 18)
                    {
                        numerosCard[i] = 9;
                    }
                }

            for (int i = 0; i < numeroDoCartao.Length; i++)
                {
                    soma += numerosCard[i];
                }

            if (soma % 10 == 0) Console.WriteLine("O cartão é valido");
            else Console.WriteLine("Cartão invalido");

            Console.ReadKey();
        }
    }
}
