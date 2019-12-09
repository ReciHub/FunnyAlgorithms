using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatataQuente
{
    class Program
    {
        //Versão da batata quente, só que em C#
        static string batataQuente(List<string> participantes, int repeticoes)
        {
            string nomeDoPerdedor;
            if (repeticoes <= participantes.Count)
            {
                nomeDoPerdedor = participantes[repeticoes - 1];
            }
            else
            {
                int numeroDeParticipantes = participantes.Count;
                while(repeticoes > numeroDeParticipantes)
                {
                    repeticoes -= numeroDeParticipantes;
                }
                nomeDoPerdedor = participantes[repeticoes - 1];
            }
            return nomeDoPerdedor;
        }

        static void Main()
        {
            List<string> pessoas = new List<string>();
            pessoas.Add("Ana");
            pessoas.Add("Alan");
            pessoas.Add("Linus");
            pessoas.Add("Paul");
            pessoas.Add("Bjarne");
            Console.WriteLine(batataQuente(pessoas, 7));
        }
    }
}
