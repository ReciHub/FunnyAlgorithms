using System;

public class Demo
{
    public static void Main(string[] args)
    {
        int x = int.Parse(Console.ReadLine());
        Console.WriteLine((x&1) == 0 ? "Number is even" : "Number is odd");
    }
}