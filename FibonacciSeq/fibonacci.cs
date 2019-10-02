using System;

public class FiboSequence
{
	
	public static void fibo(int limit){
		int a=0, b=1,c=0;
		
		while(limit>0){
			Console.Write(a + " ");
			c = a + b;
            a = b;
            b = c;
			
			limit--;
		}
	}
	
	public static void Main()
	{
		int  limit;      
    	Console.Write("Enter limit: ");
    	limit= int.Parse(Console.ReadLine());
    	if(limit>0){
    		fibo(limit);
    	}
    	else{
    			Console.Write("limit cannot be lesser than zero");
    	}
	}
}