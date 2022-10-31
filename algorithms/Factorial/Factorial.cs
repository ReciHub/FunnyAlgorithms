using System;

class MainClass
{
    static int Fatorial(int numero)
    {
        int aux1 = numero;
        while (numero > 1)
        {
            numero--;
            aux1 = aux1 * numero;
        }
        return aux1;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine("Digite um número");
        int valor = int.Parse(Console.ReadLine());
        if (valor == 1 || valor == 0)
        {
            Console.WriteLine("1");

        }
        else
        {
            int result = Fatorial(valor);
            Console.WriteLine(result);
        }
        Console.ReadLine();

    }
}