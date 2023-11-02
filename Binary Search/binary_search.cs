using System;

public class BinarySearch
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Enter the range of the sorted array: ");
        int n = int.Parse(Console.ReadLine());
        Console.WriteLine("Enter elements of the sorted array (one-line):");
        int[] ar = new int[n];
        string[] ip = Console.ReadLine().Split(' ');
        for(int i = 0; i < n; i++)
            ar[i] = int.Parse(ip[i]);
        Console.WriteLine("Enter the element to be searched: ");
        int x = int.Parse(Console.ReadLine());
        int beg = 0, end = n-1, f = 0;
        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;
            if(ar[mid] == x)
            {
                f = 1;
                Console.WriteLine($"Element found at {mid+1} position.");
                break;
            }
            else if(ar[mid] < x)
            {
                beg = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        if(f == 0)
            Console.WriteLine("Element not found!");
    }
}