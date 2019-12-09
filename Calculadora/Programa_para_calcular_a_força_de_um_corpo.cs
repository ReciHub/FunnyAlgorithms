//programa para calcular uma força de um corpo qualquer
		Console.WriteLine("Digite o valor da massa do corpo:");
		double m = double.Parse(Console.ReadLine());//está pegando o valor da massa do corpo
		Console.WriteLine("\nDigite o valor da aceleração do corpo:");
		double a = double.Parse(Console.ReadLine());//está pegando o valor da aceleração do corpo
		double f = m *a;//está multiplicando a massa com a aceleração para obter a força
		Console.WriteLine("\nO valor da força é:{0}", f);
