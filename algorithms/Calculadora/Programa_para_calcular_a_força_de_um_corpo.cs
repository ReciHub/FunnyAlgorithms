//programa para calcular uma for�a de um corpo qualquer
		Console.WriteLine("Digite o valor da massa do corpo:");
		double m = double.Parse(Console.ReadLine());//est� pegando o valor da massa do corpo
		Console.WriteLine("\nDigite o valor da acelera��o do corpo:");
		double a = double.Parse(Console.ReadLine());//est� pegando o valor da acelera��o do corpo
		double f = m *a;//est� multiplicando a massa com a acelera��o para obter a for�a
		Console.WriteLine("\nO valor da for�a �:{0}", f);
