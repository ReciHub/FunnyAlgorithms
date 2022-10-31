using System;
 
namespace numeroDecimal{
   class program{
 
       static void Main(String[] args){
           try{
               Console.WriteLine("Escreva um número");
               int numero = int.Parse(Console.ReadLine());
               Console.Clear();
               Console.WriteLine("Seu número é inteiro");
           }
           catch(Exception ex){
               Console.WriteLine("Seu número é racional");
           }
 
       }
   }
}
