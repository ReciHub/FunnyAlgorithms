using System;
					
public class Program
{
	public static void Main()
	{
		int num, numDois;

        Console.Title = "Calculadora";
        Console.WriteLine("Digite a operação");
        Console.WriteLine("Soma(+)/Subtrção(-)/Divisão(/)/Multiplicação(*)");
        string operacao = Console.ReadLine();
    	Console.Write("Primeiro número: ");
    	num = int.Parse(Console.ReadLine());
    	Console.Write("Segundo número: ");
    	numDois = int.Parse(Console.ReadLine());
        int result = 0;
        switch (operacao)
        {
            case "+":
                result = Adicao(num,numDois);
                break;
            case "-":
                result =  Subtracao(num, numDois);
                break;
            case "/":
                result =  Divisao(num, numDois);
                break;
            case "*":
                result =  Multiplicacao(num, numDois);
                break;
            default:
                Console.WriteLine("você digitou errado!");
                Main();
        }
        Console.WriteLine();

    }

  	public static int Subtracao(int num, int numDois)
  	{
    	int sub = num - numDois;
    	return sub;
  	}
    public static int Adicao(int num, int numDois)
    {
        int sub = num + numDois;
        return sub;
    }
    public static int Divisao(int num, int numDois)
    {
        int sub = num / numDois;
        return sub;
    }
    public static int Multiplicacao(int num, int numDois)
    {
        int sub = num * numDois;
        return sub;
    }
}