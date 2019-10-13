using System;
					
public class Program
{
	public static void Main()
	{
		int num, numDois;

    	Console.WriteLine ("Soma");

    	Console.Write("Primeiro número: ");
    	num = int.Parse(Console.ReadLine());
    	Console.Write("Segundo número: ");
    	numDois = int.Parse(Console.ReadLine());

    	Console.WriteLine();
    	Console.WriteLine(Soma(num: num, numDois: numDois));
  	}

  	public static int Soma(int num, int numDois)
  	{
    	int soma = num + numDois;
    	return soma;
  	}
}