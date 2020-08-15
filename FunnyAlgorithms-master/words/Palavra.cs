using System;

namespace Word
{
    class Palavra
    {
        static void Main(string[] args)
        {
            Console.Title = "Verificador de palvra";
            Console.WriteLine("Digite a frase: ");
            string palavra = Console.ReadLine();
            string[] palavraSeparada = palavra.Split(new char[] {' ' , ',' , ';' , '/',':', '-' });
            int contador = palavraSeparada.Length;
            Console.WriteLine("Sua frase tem " + contador + " palavras" );
        }
    }
}
