using System;
					
public class Program
{
	public static void Main(string[] args)
	{
		int num1, num2;

     	Console.Write("Digite o primeiro número: ");
    	num1 = int.Parse(Console.ReadLine());
    	
        Console.Write("Digite o segundo número: ");
    	num2 = int.Parse(Console.ReadLine());

    	Console.WriteLine(Multiplica(num, num2));
  	}

  	public static int Multiplica(int num1, int num2)
  	{
    	return num1 * num2;
  	}
}