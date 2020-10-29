using System;

namespace AreYouOk
{
    class AreYouOk{
        static void Main(string[] args){
            string aResp, bResp, cResp;
            Console.WriteLine("Oh, hey there, are u ok buddy?");
            aResp = Console.ReadLine();
            if (aResp == "no"||aResp =="nope")
            {
                NotOk();
            }

            else if (aResp == "yes"||aResp =="yep"||aResp =="yeah")
            {
                Console.WriteLine("Really? oh that's great");
                Console.WriteLine("Hey have you ever searched for 'sea doggos' videos?");
                bResp = Console.ReadLine();
                if (bResp == "no" ||bResp == "nope")
                {
                   DefinitelyNotOk(); 
                   Console.WriteLine("Go there right now, you don't know what you're missing");
                }
                else if (bResp == "yes"||bResp =="yep"||bResp =="yeah"){
                    Console.WriteLine("Oh! Nice");
                    Console.WriteLine("Aren't they cute?");
                    cResp = Console.ReadLine();
                     if (cResp == "no" ||cResp == "nope"){
                         DefinitelyNotOk();
                     }
                     else if(cResp == "yes"||cResp =="yep"||cResp =="yeah"){
                        AreOk();
                     }

                }
            }
        }

        static void DefinitelyNotOk(){
            Console.WriteLine("You definitely not ok.");   
        }

        static void NotOk(){
            Console.WriteLine(":("); 
            Console.WriteLine("Hope you get better my friend");   
        }
        static void AreOk(){
            Console.WriteLine(":D");
            Console.WriteLine("Well, everything actually seens ok with you");
        }
    }
}


