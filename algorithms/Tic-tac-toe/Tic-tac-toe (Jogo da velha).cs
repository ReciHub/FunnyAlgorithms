using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace ConsoleApplication1
{
 
    class Program
    {
        static int Resposta = 0;
        static int Contador = 0;
        static void ZabaoIA(string[,] jogoDaVelha, int linhaa, int colunaa, int contador)
        {
            for (int i = 0; i < jogoDaVelha.GetLength(1); i++)
                {
                    Console.Clear();    
                    Contador++;
                if ( jogoDaVelha[0,0] == "O"|| jogoDaVelha[0, 1] == "O" || jogoDaVelha[1, 0] == "O" ||jogoDaVelha[1, 1] == "O"||jogoDaVelha[1, 2] == "O" || jogoDaVelha[2, 0] == "O" || jogoDaVelha[2, 1] == "O" || jogoDaVelha[2, 2] == "O")

                { if (jogoDaVelha[0, 2] == "O")
                    {
                        if (jogoDaVelha[0, 1] != "O")
                        {
                            jogoDaVelha[0, 1] = "X";
                            if (jogoDaVelha[2, 0] == "O")
                            {
                                jogoDaVelha[2, 1] = "X";
                            }

                        }  
                    }
                    else
                    {
                        if (jogoDaVelha [1,1] != "O")
                        jogoDaVelha[1, 1] = "X";
                    }
                    }
                    if (jogoDaVelha[0, 0] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 2] == "X")
                    {

                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 0] == "X")
                    {

                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 0] == "X" && jogoDaVelha[0, 1] == "X" && jogoDaVelha[0, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }

                    else if (jogoDaVelha[0, 0] == "X" && jogoDaVelha[1, 0] == "X" && jogoDaVelha[2, 0] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 1] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 1] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "X" && jogoDaVelha[1, 2] == "X" && jogoDaVelha[2, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 1] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 1] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "X" && jogoDaVelha[1, 2] == "X" && jogoDaVelha[2, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[1, 0] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[1, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[2, 0] == "X" && jogoDaVelha[2, 1] == "X" && jogoDaVelha[2, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else
                    {
                    }
                AssentosVagos(jogoDaVelha);
                }
            }
        static void Zabao(string[,] jogoDaVelha, int linhaa, int colunaa, int contador)
        {
            for (int j = 0; j < jogoDaVelha.GetLength(0); j++)
            {
                for (int i = 0; i < jogoDaVelha.GetLength(1); i++)
                {
                    Console.Clear();
                    if(jogoDaVelha[0,0] != " "&& jogoDaVelha[0, 1] != " " && jogoDaVelha[0, 2] != " " && jogoDaVelha[1, 0] != " " && jogoDaVelha[1, 1] != " " && jogoDaVelha[1, 2] != " " && jogoDaVelha[2, 0] != " " && jogoDaVelha[2, 1] != " " && jogoDaVelha[2, 2] != " ")
                    {
                        Console.Clear();
                        Console.WriteLine("DEU VELHA");
                        Console.ReadLine();
                    }
                    if (jogoDaVelha[linhaa, colunaa] == "X")
                    {
                        Console.WriteLine("           ESTE LOCAL JÁ ESTÁ MARCADO ");
                        System.Threading.Thread.Sleep(500);
                        Console.Clear();
                        Contador = 3;
                        AssentosVagos(jogoDaVelha);
                    }
                    else if (jogoDaVelha[linhaa, colunaa] == "O")
                    {
                        Console.WriteLine("           ESTE LOCAL JÁ ESTÁ MARCADO ");
                        System.Threading.Thread.Sleep(500);
                        Console.Clear();
                        Contador = 3;
                        AssentosVagos(jogoDaVelha);
                    }
                    jogoDaVelha[linhaa, colunaa] = "X";
                    if (jogoDaVelha[0, 0] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 2] == "X")
                    {

                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 0] == "X")
                    {

                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 0] == "X" && jogoDaVelha[0, 1] == "X" && jogoDaVelha[0, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }

                    else if (jogoDaVelha[0, 0] == "X" && jogoDaVelha[1, 0] == "X" && jogoDaVelha[2, 0] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 1] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 1] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "X" && jogoDaVelha[1, 2] == "X" && jogoDaVelha[2, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 1] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[2, 1] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "X" && jogoDaVelha[1, 2] == "X" && jogoDaVelha[2, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[1, 0] == "X" && jogoDaVelha[1, 1] == "X" && jogoDaVelha[1, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[2, 0] == "X" && jogoDaVelha[2, 1] == "X" && jogoDaVelha[2, 2] == "X")
                    {
                        Console.WriteLine("X GANHARAM");
                        Console.ReadLine();
                    }
                    else
                    {
                    }
                    AssentosVagos(jogoDaVelha);
                }
            }
        }
        static void Sabao(string[,] jogoDaVelha, int linhaa, int colunaa, int contador)
        {
            for (int j = 0; j < jogoDaVelha.GetLength(0); j++)
            {
                for (int i = 0; i < jogoDaVelha.GetLength(1); i++)
                {


                    Console.Clear();
                    if (jogoDaVelha[linhaa, colunaa] == "X")
                    {
                        Console.WriteLine("           ESTE LOCAL JÁ ESTÁ MARCADO ");
                        System.Threading.Thread.Sleep(500);
                        Console.Clear();
                        Contador = 0;
                        AssentosVagos(jogoDaVelha);
                    }
                    else if (jogoDaVelha[linhaa, colunaa] == "O")
                    {
                        Console.WriteLine("           ESTE LOCAL JÁ ESTÁ MARCADO ");
                        System.Threading.Thread.Sleep(500);
                        Console.Clear();
                        Contador = 0;
                        AssentosVagos(jogoDaVelha);
                    }
                    jogoDaVelha[linhaa, colunaa] = "O";
                    if (jogoDaVelha[0, 0] == "O" && jogoDaVelha[1, 1] == "O" && jogoDaVelha[2, 2] == "O")
                    {

                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "O" && jogoDaVelha[1, 1] == "O" && jogoDaVelha[2, 0] == "O")
                    {

                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 0] == "O" && jogoDaVelha[0, 1] == "O" && jogoDaVelha[0, 2] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }

                    else if (jogoDaVelha[0, 0] == "O" && jogoDaVelha[1, 0] == "O" && jogoDaVelha[2, 0] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 1] == "O" && jogoDaVelha[1, 1] == "O" && jogoDaVelha[2, 1] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "O" && jogoDaVelha[1, 2] == "O" && jogoDaVelha[2, 2] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 1] == "O" && jogoDaVelha[1, 1] == "O" && jogoDaVelha[2, 1] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[0, 2] == "O" && jogoDaVelha[1, 2] == "O" && jogoDaVelha[2, 2] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[1, 0] == "O" && jogoDaVelha[1, 1] == "O" && jogoDaVelha[1, 2] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (jogoDaVelha[2, 0] == "O" && jogoDaVelha[2, 1] == "O" && jogoDaVelha[2, 2] == "O")
                    {
                        Console.WriteLine("CIRCULOS GANHARAM");
                        Console.ReadLine();
                    }
                    else if (Resposta == 2)
                       {
                        ZabaoIA(jogoDaVelha, linhaa, colunaa, contador);
                    }

                    contador++;
                    AssentosVagos(jogoDaVelha);

                }
            }
        }
        static void AssentosVagos(string[,] jogoDaVelha)
        {
            Console.Title = "JOGO DA VELHA";
            int contador = 0;
            int cont = 0;
            int conta = 0;
            Console.WriteLine("               0     1      2 ");
            for (int linha = 0; linha < jogoDaVelha.GetLength(0); linha++)
            {

                for (int coluna = 0; coluna < jogoDaVelha.GetLength(1); coluna++)
                {          
                    if (cont == 3)
                    {
                        Console.WriteLine();
                        Console.WriteLine("              ________________");
                        Console.Write("           " + linha + "");
                        cont = 0;
                        conta++;
                    }
                    else if (cont == 0)
                    {
                        Console.Write("           " + cont);
                    }

                    if (jogoDaVelha[linha, coluna] == "O")
                    {
                        Console.ForegroundColor = ConsoleColor.Cyan;
                    }
                    else { Console.ForegroundColor = ConsoleColor.Red; }
                    Console.Write("  " + jogoDaVelha[linha, coluna]);
                    Console.ForegroundColor = ConsoleColor.Gray;
                    if (coluna < 2)
                    {
                        Console.Write("   |");
                    }
                    cont++;
                    conta++;

                }

            }
            string ZARA;
            if ((Contador % 2) != 0)
            {
                ZARA = " XIS";
            }
            else
            {
                ZARA = " CIRCULO";
            }

            if (jogoDaVelha[0, 0] != " " && jogoDaVelha[0, 1] != " " && jogoDaVelha[0, 2] != " " && jogoDaVelha[1, 0] != " " && jogoDaVelha[1, 1] != " " && jogoDaVelha[1, 2] != " " && jogoDaVelha[2, 0] != " " && jogoDaVelha[2, 1] != " " && jogoDaVelha[2, 2] != " ")
            {
                Console.Clear();
                Console.WriteLine("DEU VELHA");
                Console.ReadLine();
            }
            Console.Write(" \n\n Escolha a linha do");
            if (ZARA == " XIS")
            { Console.ForegroundColor = ConsoleColor.Red; }
            else { Console.ForegroundColor = ConsoleColor.Cyan; }
            Console.Write(" " + ZARA);
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine();
            int linhaa = int.Parse(Console.ReadLine());
            Console.Write("Escolha a coluna do");
            if (ZARA == " XIS")
            { Console.ForegroundColor = ConsoleColor.Red; }
            else { Console.ForegroundColor = ConsoleColor.Cyan; }
            Console.Write(" " + ZARA);
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine();
            int colunaa = int.Parse(Console.ReadLine());
            if (Resposta == 2)
            {
                Contador++;
                Sabao(jogoDaVelha, linhaa, colunaa, contador);
            }
            else if ((Contador % 2) != 0)
            {
                Contador++;
                Zabao(jogoDaVelha, linhaa, colunaa, contador);

            }
            else
            {
                Contador++;
                Sabao(jogoDaVelha, linhaa, colunaa, contador);
            }
        }
        static void Main(string[] args)
        {
            string[,] jogoDaVelha = { { " ", " ", " " },
                                      { " ", " ", " " },
                                      { " ", " ", " " }};
            Console.Write("B"); Thread.Sleep(90); Console.Write("e"); Thread.Sleep(90); Console.Write("m"); Thread.Sleep(90); Console.Write(" V"); Thread.Sleep(90); Console.Write("i"); Thread.Sleep(90); Console.Write("n"); Thread.Sleep(90); Console.Write("d"); Thread.Sleep(90); Console.Write("o"); Thread.Sleep(90); Console.Write(" a"); Thread.Sleep(90); Console.Write("o"); Thread.Sleep(90); Console.Write(" J"); Thread.Sleep(90); Console.Write("O"); Thread.Sleep(90); Console.Write("G"); Thread.Sleep(50); Console.Write("O"); Thread.Sleep(90); Console.Write(" D"); Thread.Sleep(90); Console.Write("A"); Thread.Sleep(90); Console.Write(" V"); Thread.Sleep(90); Console.Write("E"); Thread.Sleep(90); Console.Write("L"); Thread.Sleep(90); Console.Write("H"); Thread.Sleep(90); Console.Write("A"); Thread.Sleep(90); Console.Write("!");
            Console.WriteLine("\n\"1\" PARA DOIS JOGADORES E \"2\" PARA JOGAR CONTRA UMA IA");
            Resposta=int.Parse(Console.ReadLine());
            while (Contador != -1)
            {
                if (Resposta == 1)
                {
                    Console.Clear();
                    AssentosVagos(jogoDaVelha);
                }
                else if (Resposta == 2)
                {
                    Console.Clear();
                    AssentosVagos(jogoDaVelha);
                }
                else
                {
                    Console.WriteLine("UM OU DOIS CARA!");
                    Thread.Sleep(600);
                    Console.Clear();
                    Console.WriteLine("Bem vindo ao JOGO DA VELHA!");
                    Console.WriteLine("\"1\" PARA DOIS JOGADORES E \"2\" PARA JOGAR CONTRA UMA IA");
                    Resposta = int.Parse(Console.ReadLine());

                }
            }

        }


    }
}


