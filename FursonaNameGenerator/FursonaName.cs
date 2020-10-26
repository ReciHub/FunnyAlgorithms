using System;

namespace FursonaNameGenerator
{
    class FursonaName
    {
        static void Main(string[] args)
        {
            string sim_no;
            int dia, mes;
            System.Console.WriteLine("Opa, eae beleza? ta afim de ver qual seria a tua fursona artista?");
            si_no = Console.ReadLine();
            if (sim_no == "não"||si_no == "nao")
            {
                System.Console.WriteLine("Bom você vai ver querendo ou não :)");
            }
            else
            {
                System.Console.WriteLine("Beleza!");
            }
            System.Console.WriteLine("Escreve o dia que tu nasceu ai");
            dia = int.Parse(Console.ReadLine());
            System.Console.WriteLine("agora o mês (ex: '1' pra janeiro)");
            mes = int.Parse(Console.ReadLine());

            string[] dias = new string[] {
"Guaxinim","Catchorineo","Taruga","Camaleão","Raposão", "Anta", "Leão","Ratão","Ursão","Alvin e os esquilos","Capivara","Burro","Piriquito","Loro","Morceguin","Doguin"};

            string[] meses = new string[] {"MC", "Bonde do/a","Rei", "Lil","Pagodinho", "do gera"};

        if (dia > 16)
        {
            dia -= 16;
        }
        if (mes > 6)
        {
            mes-=6;
        }

     for (int i = 0; i <= 16; i++)
    {    
      for (int j = 0; j <= 6; j++){
            if (i == dia-1 && j == mes-1)
            { if (mes<=4){
                System.Console.WriteLine("Bom, seu nome artistico da sua seria: " + meses[j] + " " + dias[i]+"!");    
            }
            else{
               System.Console.WriteLine("Bom, seu nome artistico da sua seria: " + dias[i] + " " + meses[j]+"!");    
            }
            }
        }
    }

            
           
        } 
    }
}
