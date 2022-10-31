using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace URI
{
    class Program
    {
        static void Main(string[] args)
        {
            //Conversão de massa


            Console.WriteLine("Digite um valor o tipo de massa que você deseja converter e digite seu tipo de mediada agora \n obs: aceita apenas quilo=Q, libra=L, onça=O, grama=G, Tonelada=T");
            Console.WriteLine("\ndigite o tipo da medida que você queer converter:");
            char Tipo_1 = char.Parse(Console.ReadLine());
            Console.WriteLine("\ndigite o tipo da medida que você possuí:");
            char Tipo_2 = char.Parse(Console.ReadLine());
            switch (Tipo_1)
            {
                case 'Q':

                    switch (Tipo_2)
                    {
                        case 'L':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            double medida_1 = double.Parse(Console.ReadLine());
                            double medida_2 = medida_1 * 2.205;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'O':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 35.274;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;
                        case 'G':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 1000;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;
                        case 'T':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 / 1000;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                    }
                    break;
                case 'L':
                    switch (Tipo_2)
                    {
                        case 'Q':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            double medida_1 = double.Parse(Console.ReadLine());
                            double medida_2 = medida_1 / 2.205;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'O':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 16;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'G':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 453.592;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'T':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 / 2204.623;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                    }
                    break;
                case 'T':
                    switch (Tipo_2)
                    {
                        case 'Q':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            double medida_1 = double.Parse(Console.ReadLine());
                            double medida_2 = medida_1 * 1000;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'O':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 35273.962;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'G':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 1000000;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'L':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 * 2204.623;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                    }
                    break;
                case 'O':
                    {
                        switch (Tipo_2)
                        { 
                case 'Q':
                    Console.WriteLine("digite o valor da medida que você possuí:");
                    double medida_1 = double.Parse(Console.ReadLine());
                    double medida_2 = medida_1 / 35.274;
                    Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                    break;

                case 'L':
                     Console.WriteLine("digite o valor da medida que você possuí:");
                    medida_1 = double.Parse(Console.ReadLine());
                    medida_2 = medida_1 / 16;
                    Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                    break;

                case 'G':
                    Console.WriteLine("digite o valor da medida que você possuí:");
                    medida_1 = double.Parse(Console.ReadLine());
                    medida_2 = medida_1 / 28.35;
                    Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                    break;

                case 'T':
                    Console.WriteLine("digite o valor da medida que você possuí:");
                     medida_1 = double.Parse(Console.ReadLine());
                    medida_2 = medida_1 / 35273.962;
                    Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                    break;
            }
            break; }
                case 'G':
                    switch (Tipo_2)
                    {
                        case 'Q':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            double medida_1 = double.Parse(Console.ReadLine());
                            double medida_2 = medida_1 / 1000;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'L':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 / 453.592;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'O':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 / 28.35;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;

                        case 'T':
                            Console.WriteLine("digite o valor da medida que você possuí:");
                            medida_1 = double.Parse(Console.ReadLine());
                            medida_2 = medida_1 / 1000000;
                            Console.WriteLine(medida_1 + "é igual  à:{0}", medida_2);
                            break;
                    }
                            break;

            }
            Console.Read();
            }
          

    




        }
    }

