using System;
					
public class Program
{
	public static void Main()
	{
		int num, numDois;

    	Console.WriteLine ("Subtração");

    	Console.Write("Primeiro número: ");
    	num = int.Parse(Console.ReadLine());
    	Console.Write("Segundo número: ");
    	numDois = int.Parse(Console.ReadLine());

    	Console.WriteLine();
    	Console.WriteLine(Subtracao(num: num, numDois: numDois));
  	}

  	public static int Subtracao(int num, int numDois)
  	{
    	int sub = num - numDois;
    	return sub;
  	}
}