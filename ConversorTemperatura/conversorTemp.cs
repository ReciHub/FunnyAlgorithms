using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace ConversorDeTemperatura_3._0	//by OTalDoL2
{
    class Program
    {
        static double CFK(double C, double F, double K, int type)
        {
            //initTemp is the initial temperature, finalTemp is the final temperature
            //and type was the conversion method, example: type is °C to °F
            double initTemp = 0;
            double finalTemp = 0;

            if (type == 1)
            {

                C = Convert.ToDouble(Console.ReadLine());  // Initial Temperature
                initTemp = C;
                finalTemp = initTemp * 9 / 5 + 32; //Converted is °C, and Converter is °F
                Console.Write(initTemp + "°C is equal to " + finalTemp + "°F");
            }

            else if (type == 2)
            {
                F = Convert.ToDouble(Console.ReadLine());
                initTemp = F;
                finalTemp = ((initTemp - 32) * 5 / 9); //initTemp is °F, and finalTemp is °C
                Console.Write(initTemp + "°F is equal to " + finalTemp + "°C");
            }

            if (type == 3)
            {
                F = Convert.ToDouble(Console.ReadLine());
                initTemp = F;
                finalTemp = ((initTemp - 32) * 5 / 9 + 273.15); //initTemp is °F, and finalTemp is K
                Console.Write(initTemp + "°F is equal to " + finalTemp + "K");
            }

            else if (type == 4)
            {
                K = Convert.ToDouble(Console.ReadLine());
                initTemp = K;
                finalTemp = ((initTemp - 273.15) * 9 / 5 + 32); //initTemp is K, and finalTemp is °F
                Console.Write(initTemp + " K is equal to " + finalTemp + "°F");
            }

            else if (type == 5)
            {
                K = Convert.ToDouble(Console.ReadLine());
                initTemp = K;
                finalTemp = (initTemp - 273.15);  //initTemp is K, and finalTemp is °C
                Console.Write(initTemp + " K is equal to " + finalTemp + "°C");
            }

            else if (type == 6)
            {
                C = Convert.ToDouble(Console.ReadLine());
                initTemp = C;
                finalTemp = (initTemp + 273.15); //initTemp is °C, and finalTemp is K
                Console.Write(initTemp + "°C is equal to " + finalTemp + " K");
            }

            return finalTemp;
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Primeiramente coloque o programa em TELA CHEIA");
            Thread.Sleep(8000);
            Console.Clear();

            Console.WriteLine("Seja bem-vindo ao \n\n");
            Thread.Sleep(5000);
            Console.WriteLine("					 ::::::::     ::::::::    ::::    :::   :::     :::  ::::::::::  :::::::::    ::::::::    ::::::::   :::::::::  ");
            Thread.Sleep(800);
            Console.WriteLine("					:+:    :+:   :+:    :+:   :+:+:   :+:   :+:     :+:  :+:         :+:    :+:  :+:    :+:  :+:    :+:  :+:    :+: ");
            Thread.Sleep(800);
            Console.WriteLine("					+:+          +:+    +:+   :+:+:+  +:+   +:+     +:+  +:+         +:+    +:+  +:+         +:+    +:+  +:+    +:+ ");
            Thread.Sleep(800);
            Console.WriteLine("					+#+          +#+    +:+   +#+ +:+ +#+   +#+     +:+  +#++:++#    +#++:++#:   +#++:++#++  +#+    +:+  +#++:++#:  ");
            Thread.Sleep(800);
            Console.WriteLine("					+#+          +#+    +#+   +#+  +#+#+#    +#+   +#+   +#+         +#+    +#+         +#+  +#+    +#+  +#+    +#+ ");
            Thread.Sleep(800);
            Console.WriteLine("					#+#    #+#   #+#    #+#   #+#   #+#+#     #+#+#+#    #+#         #+#    #+#  #+#    #+#  #+#    #+#  #+#    #+# ");
            Thread.Sleep(800);
            Console.WriteLine("				 	 ########     ########    ###    ####       ###      ##########  ###    ###   ########    ########   ###    ### ");
            Thread.Sleep(800);
            Console.WriteLine("\n");
            Thread.Sleep(800);
            Console.ForegroundColor = ConsoleColor.Red;
            Thread.Sleep(800);
            Console.WriteLine("										:::::::::   :::::::::: ");
            Thread.Sleep(800);
            Console.WriteLine("										:+:    :+:  :+:        ");
            Thread.Sleep(800);
            Console.WriteLine("										+:+    +:+  +:+        ");
            Thread.Sleep(800);
            Console.WriteLine("										+#+    +:+  +#++:++#   ");
            Thread.Sleep(800);
            Console.WriteLine("										+#+    +#+  +#+        ");
            Thread.Sleep(800);
            Console.WriteLine("										#+#    #+#  #+#        ");
            Thread.Sleep(800);
            Console.WriteLine("										#########   ########## ");
            Thread.Sleep(800);
            Console.WriteLine("\n");
            Thread.Sleep(800);
            Console.ForegroundColor = ConsoleColor.Blue;
            Thread.Sleep(800);
            Console.WriteLine("			:::::::::::  ::::::::::  ::::    ::::   :::::::::   ::::::::::  :::::::::       :::      :::::::::::  :::    :::  :::::::::       :::     ");
            Thread.Sleep(800);
            Console.WriteLine("    			    :+:      :+:         +:+:+: :+:+:+  :+:    :+:  :+:         :+:    :+:    :+: :+:        :+:      :+:    :+:  :+:    :+:    :+: :+:   ");
            Thread.Sleep(800);
            Console.WriteLine("    			    +:+      +:+         +:+ +:+:+ +:+  +:+    +:+  +:+         +:+    +:+   +:+   +:+       +:+      +:+    +:+  +:+    +:+   +:+   +:+  ");
            Thread.Sleep(800);
            Console.WriteLine("			    +#+      +#++:++#    +#+  +:+  +#+  +#++:++#+   +#++:++#    +#++:++#:   +#++:++#++:      +#+      +#+    +:+  +#++:++#:   +#++:++#++: ");
            Thread.Sleep(800);
            Console.WriteLine("			    +#+      +#+         +#+       +#+  +#+         +#+         +#+    +#+  +#+     +#+      +#+      +#+    +#+  +#+    +#+  +#+     +#+ ");
            Thread.Sleep(800);
            Console.WriteLine("			    #+#      #+#         #+#       #+#  #+#         #+#         #+#    #+#  #+#     #+#      #+#      #+#    #+#  #+#    #+#  #+#     #+# ");
            Thread.Sleep(800);
            Console.WriteLine("			    ###      ##########  ###       ###  ###         ##########  ###    ###  ###     ###      ###       ########   ###    ###  ###     ### ");
            Thread.Sleep(800);
            Console.WriteLine("\n");
            Console.ForegroundColor = ConsoleColor.Yellow;
            Thread.Sleep(800);
            Console.WriteLine("										 ::::::::       :::::::");
            Thread.Sleep(800);
            Console.WriteLine("										:+:    :+:     :+:   :+: ");
            Thread.Sleep(800);
            Console.WriteLine("										       +:+     +:+  :+:+ ");
            Thread.Sleep(800);
            Console.WriteLine("										    +#++:      +#+ + +:+ ");
            Thread.Sleep(800);
            Console.WriteLine("										       +#+     +#+#  +#+ ");
            Thread.Sleep(800);
            Console.WriteLine("										#+#    #+# #+# #+#   #+#");
            Thread.Sleep(800);
            Console.WriteLine("										 ########  ###  #######");
            Thread.Sleep(800);

            double C = 0;   //Variable representing degrees Celsius (°C)
            double K = 0;   //Variable representing Kelvin (K)
            double F = 0;   //Variable representing degrees Fahrenheit (°F)

            Console.Clear();

            //Here the user will choose which timescales he wants to change
            Console.WriteLine("If you want to convert from Celsius to Fahrenheit ... type 1 and press enter: ");
            Console.WriteLine("If you want to convert from Fahrenheit to Celsius ... type 2 and hit enter:");
            Console.WriteLine("If you want to convert from Fahrenheit to Kelvin ... type 3 and hit enter:");
            Console.WriteLine("If you want to convert from Kelvin to Fahrenheit ... type 4 and hit enter:");
            Console.WriteLine("If you want to convert from Kelvin to Celsius ... type 5 and hit enter:");
            Console.WriteLine("If you want to convert from Celsius to Kelvin ... type 6 and hit enter:");

            int type = int.Parse(Console.ReadLine());

            CFK(C, K, F, type);
        }
    }
}
