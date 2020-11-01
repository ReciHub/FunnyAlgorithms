using System; 

class Areas {

    static void Main(string[] args) { 
            string r;
            String[] medidas;
            String[] medidas2;
            double h = 0, b= 0, A= 0, B= 0, C= 0, L = 0;

            System.Console.WriteLine("Que área deseja calcular?");
            r = Console.ReadLine();
           if (r == "Retangulo" ||  r == "Triangulo")
           {
            System.Console.WriteLine("Medidas: ");
            medidas = System.Console.ReadLine().Split(' ');
             b = double.Parse(medidas[0]);
             h = double.Parse(medidas[1]);
                if (r == "Retangulo")
                {
                  double areaR = b * h;
                  Console.WriteLine("AREA RETANGULO: {0}",areaR.ToString("0.0"));
                }
                else if (r == "Triangulo"){
                 double areaT = (b * h) / 2.0;
                 Console.WriteLine("AREA TRIANGULO: {0}",areaT.ToString("0.0"));
                }
           }
            else if (r == "Trapezio"){
            System.Console.WriteLine("Medidas: ");
            medidas2 = System.Console.ReadLine().Split(' ');
             A = double.Parse(medidas2[0]);
             B = double.Parse(medidas2[1]);
             C = double.Parse(medidas2[2]);

                  double areaTP = (A + B) * C / 2.0;
                  Console.WriteLine(" AREA TRAPEZIO: {0}",areaTP.ToString("0.0"));
              
           }  

           else if (r == "Circulo"||r =="Quadrado"){
                System.Console.WriteLine("Medidas: ");
                medidas = System.Console.ReadLine().Split(' ');
                L = double.Parse(medidas[0]);
                if (r =="Quadrado")
                {
                    double areaQ = L * L;
                    Console.WriteLine("AREA QUADRADO: {0}",areaQ.ToString("0.0"));
                } 
                else if (r == "Circulo"){
                  double areaC =  3.14159 * L * L;
                  Console.WriteLine("AREA CIRCULO: {0}",areaC.ToString("0.0"));
                }

           }
           
    }

}