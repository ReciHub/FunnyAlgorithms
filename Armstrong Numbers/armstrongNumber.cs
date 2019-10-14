using System;

  public class ArmstrongExample  
   {  
     public static void Main(string[] args)  
      {  
       int  number,remainder,sum=0,temp;      
       Console.Write("Enter positive Number= ");      
       number= int.Parse(Console.ReadLine());
       if(number>0){
       temp=number;      
       while(number>0)      
       {      
        remainder=number%10;      
        sum=sum+(remainder*remainder*remainder);      
        number=number/10;      
       }      
       if(temp==sum)      
        Console.Write("Armstrong Number.");      
       else      
        Console.Write("Not Armstrong Number.");      
      }  
      else{
      	Console.Write("Armstrong number cannot be negative");
      }
    }
  } 