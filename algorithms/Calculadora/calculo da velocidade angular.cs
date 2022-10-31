//programa para calcular a velocidade angular de um corpo
             Console.WriteLine("quais dados você posssuí do corpo: \n obs: delta tempo(t), delta fi(f), período(T), pi(p), frequência(F), velocidade(v), raio(r)\n os dados devem estar no SI");
             Console.Write("\ndigite  primeiro dado: ");
             char dado_1 = char.Parse(Console.ReadLine());
             Console.Write("digite  segundo dado: ");
             char dado_2 = char.Parse(Console.ReadLine());
             double valor_1 = 0;
             double valor_2 = 0;
             double v_angular = 0;

             if (dado_1 == 't' & dado_2 == 'f' || dado_2 == 't' & dado_1 == 'f')
             {
                 Console.Write("\nDigite o valor do espaço angular:");
                 valor_1 = double.Parse(Console.ReadLine());
                 Console.Write("Digite o valor do tempo:");
                 valor_2 = double.Parse(Console.ReadLine());
                 v_angular = valor_1 / valor_2;
                 Console.WriteLine("a velocidade angular desse corpo é:{0}", v_angular);
             }

             else if (dado_1 == 'p' & dado_2 == 'T' || dado_2 == 'p' & dado_1 == 'T')


     {
                 Console.Write("\nDigite o valor de pi:");
                 valor_1 = double.Parse(Console.ReadLine());
                 Console.Write("Digite o valor do período:");
                 valor_2 = double.Parse(Console.ReadLine());
                 v_angular = (valor_1*2) / valor_2;
                 Console.WriteLine("a velocidade angular desse corpo é:{0}", v_angular);
             }
             else if (dado_1 == 'p' & dado_2 == 'F' || dado_2 == 'p' & dado_1 == 'F')

     {
                 Console.Write("\n Digite o valor de pi:");
                 valor_1 = double.Parse(Console.ReadLine());
                 Console.Write("Digite o valor do período:");
                 valor_2 = double.Parse(Console.ReadLine());
                 v_angular = (valor_1 * 2) * valor_2;
                 Console.WriteLine("a velocidade angular desse corpo é:{0}", v_angular);
             }
             else if (dado_1 == 'v' & dado_2 == 'r' || dado_2 == 'v' & dado_1 == 'r')

             {
                 Console.Write("\n Digite o valor de da velocidade:");
                 valor_1 = double.Parse(Console.ReadLine());
                 Console.Write("Digite o valor do raio:");
                 valor_2 = double.Parse(Console.ReadLine());
                 v_angular = valor_1 / valor_2;
                 Console.WriteLine("a velocidade angular desse corpo é:{0}", v_angular + "rad/s");
             }*/
