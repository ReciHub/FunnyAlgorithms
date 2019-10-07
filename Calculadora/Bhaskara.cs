using System;
					
public class Program
{
	public static void Main()
	{
		double a, b, c, delta, bhaskara;
		
    		a = 0;
   		b = 0;
    		c = 0;
		delta = 0;
		bhaskara = 0;
		
		Console.Write("a: ");
		a = double.Parse(Console.ReadLine());
		
		Console.Write("b: ");
		b = double.Parse(Console.ReadLine());
		
		Console.Write("c: ");
		c = double.Parse(Console.ReadLine());
		
		delta = CalculoDelta(a: a, b: b, c: c);

    		Console.WriteLine();

		Console.WriteLine("Positivo: {0} - Negativo: {1}", CalculoBhaskaraP(a: a, b: b, delta: delta, bhaskarap: bhaskara), CalculoBhaskaraN(a: a, b: b, delta: delta, bhaskaran: bhaskara));
	}
	
	public static double CalculoDelta(double a, double b, double c)
	{
		double delta = (b * b) - (4 * (a * c));
		return delta;
	}
	
	public static double CalculoBhaskaraP(double delta, double bhaskarap, double a, double b)
	{
    		double quadrado = (double)Math.Sqrt(delta);
		bhaskarap = ((b * b) + quadrado) / 2 * a;
		return bhaskarap;
	}
	
	public static double CalculoBhaskaraN(double delta, double bhaskaran, double a, double b)
	{
    		double quadrado = (double)Math.Sqrt(delta);
		bhaskaran = ((b * b) - quadrado) / 2 * a;
		return bhaskaran;
	}
}