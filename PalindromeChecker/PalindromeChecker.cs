using System;

class PalindromeChecker
{
	static void Main(string[] args)
	{
		Console.WriteLine("Enter a string (spaces will be removed):");
		string rawInput = Console.ReadLine();
		string input = rawInput.ToLowerInvariant().Replace(" ", string.Empty);

		int length = input.Length;
		int half = length / 2;

		bool isPalindrome = true;
		for (int i = 0; i < half && isPalindrome; i++)
			isPalindrome &= (input[i] == input[length - i - 1]);

		Console.WriteLine();
		Console.WriteLine("\"{0}\" is {1}a palindrome!", rawInput, isPalindrome ? string.Empty : "not ");
		Console.ReadKey();
	}
}
