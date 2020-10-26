using System; 

class Bhaskara {

static void Main(string[] args) { 
double A, B, C,delta, R1, R2;
System.Console.WriteLine("Opa! quer resolver uma equação de segundo grau (completa!) mas ta com preguiça? Deixe-me lhe ajudar, só escrever os valores de A, B e C (nessa ordem e só colocando um espaço entre cada)");
            string[] valor = Console.ReadLine().Split(' ');
            A = double.Parse(valor[0]);
            B = double.Parse(valor[1]);
            C = double.Parse(valor[2]);

            //conta 1

            delta = (B * B) - 4 * A * C;
           

            if (delta < 0.00 || A == 0)
            {
                Console.WriteLine("Opa, não é possivel calcular, verifique se 'A' não é igual a 0, caso não, o delta da conta está dando negativo :/ Tente com outros valores");
            }

            //conta 2

            else
            {
                R1 = (-B + Math.Sqrt(delta))/(2*A);
                R2 = (-B - Math.Sqrt(delta))/(2*A);

                Console.WriteLine("As raizes são:");
                Console.WriteLine("Raiz1 = {0:0.00}",R1) ;
                Console.WriteLine("Raiz2 = {0:0.00}",R2);
            }
            

    }

}