using System;

public class GCD
{
    public static void Main(string[] args)
    {
        string[] ip = Console.ReadLine().Split(' ');
        int a = int.Parse(ip[0]);
        int b = int.Parse(ip[1]);
        Console.WriteLine($"The GCD of {a} and {b} is {gcd(a, b)}");
    }
    
    public static int gcd(int a, int b)
    {
        if(a % b == 0) 
            return b;
        return gcd(b, a % b);
    }
}