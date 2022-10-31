using System;

namespace sorvete{
    class Program{
        static void Main(String[] args){
            Console.WriteLine("Digite a posição inicial: ");
           int posicInicial = int.Parse(Console.ReadLine);
            Console.WriteLine("Digite a velocidade: ");
           int veloc = int.Parse(Console.ReadLine);
            Console.WriteLine("Digite o tempo: ");
           int temp = int.Parse(Console.ReadLine);
           Console.Clear();
           int result = posicInicial + (veloc * temp);
           Console.WriteLine("A posisão final é: {0}", result );
           Console.ReadLine();
        }
    }
} 