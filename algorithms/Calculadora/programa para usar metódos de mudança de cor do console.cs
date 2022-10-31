
            // programinha para ficar com epilepsia
            Console.WriteLine("você que ficar com epilepsia?");
            string pergunta_fundamental= Console.ReadLine();
            Console.Clear();
            if (pergunta_fundamental == "sim")
            {
                for (int i=1000;i>0;i++)
                {
                    Console.BackgroundColor = ConsoleColor.Red;
                    Console.ForegroundColor = ConsoleColor.Blue;
                    Console.WriteLine("you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,");
                    Console.BackgroundColor = ConsoleColor.Gray;
                    Console.ForegroundColor = ConsoleColor.Black;
                    Console.WriteLine("you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,");
                    Console.BackgroundColor = ConsoleColor.Yellow;
                    Console.ForegroundColor = ConsoleColor.Cyan;
                    Console.WriteLine("you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,");
                    Console.BackgroundColor = ConsoleColor.Blue;
                    Console.ForegroundColor = ConsoleColor.DarkMagenta;
                    Console.WriteLine("you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,you freak your mind,");
                }
            }

            else
            {
                Console.WriteLine("Você é muito sem graça");
            }
