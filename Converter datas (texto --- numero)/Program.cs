using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Conversor_Data
{
    class Program
    {
        static void Main(string[] args)
        {
            string diaText, mesText;
            int dia, mes;

            Console.Write("Escreva o dia em formato de texto para ser convertido em numero: ");
            diaText = Console.ReadLine();
            Console.Write("Escreva o mes em formato de texto para ser convertido em numero: ");
            mesText = Console.ReadLine();

            switch (diaText)
            {
                case "um":
                    dia = 01;
                    break;

                case "dois":
                    dia = 02;
                    break;

                case "três":
                    dia = 03;
                    break;

                case "quatro":
                    dia = 04;
                    break;

                case "cinco":
                    dia = 05;
                    break;

                case "seis":
                    dia = 06;
                    break;

                case "sete":
                    dia = 07;
                    break;

                case "oito":
                    dia = 08;
                    break;

                case "nove":
                    dia = 09;
                    break;

                case "dez":
                    dia = 10;
                    break;

                case "onze":
                    dia = 11;
                    break;

                case "doze":
                    dia = 12;
                    break;

                case "treze":
                    dia = 13;
                    break;

                case "quatorze":
                    dia = 14;
                    break;

                case "catorze":
                    dia = 14;
                    break;

                case "quinze":
                    dia = 15;
                    break;

                case "dezeseis":
                    dia = 16;
                    break;

                case "dezesete":
                    dia = 17;
                    break;

                case "dezoito":
                    dia = 18;
                    break;

                case "dezenove":
                    dia = 19;
                    break;

                case "vinte":
                    dia = 20;
                    break;

                case "vinte e um":
                    dia = 21;
                    break;

                case "vinte e dois":
                    dia = 22;
                    break;

                case "vinte e treis":
                    dia = 23;
                    break;

                case "vite e quatro":
                    dia = 24;
                    break;

                case "vinte e cinco":
                    dia = 25;
                    break;

                case "vinte e seis":
                    dia = 26;
                    break;

                case "vinte e sete":
                    dia = 27;
                    break;

                case "vinte e oito":
                    dia = 28;
                    break;

                case "vinte e nove":
                    dia = 29;
                    break;

                case "trinta":
                    dia = 30;
                    break;

                case "trinta e dois":
                    dia = 32;
                    break;

                default:
                    dia = 404;
                break;
            }

            switch (mesText)
            {
                case "janeiro":
                    mes = 01;
                    break;

                case "fevereiro":
                    mes = 02;
                    break;

                case "março":
                    mes = 03;
                    break;

                case "abril":
                    mes = 04;
                    break;

                case "maio":
                    mes = 05;
                    break;

                case "junho":
                    mes = 06;
                    break;

                case "julho":
                    mes = 07;
                    break;

                case "agosto":
                    mes = 08;
                    break;

                case "setembro":
                    mes = 09;
                    break;

                case "outubro":
                    mes = 10;
                    break;

                case "novembro":
                    mes = 11;
                    break;

                case "dezembro":
                    mes = 12;
                    break;

                default:
                    mes = 404;
                    break;
            }

            Console.WriteLine("{0}/{1}/2019", dia, mes);
            Console.ReadKey();
        }
    }
}
