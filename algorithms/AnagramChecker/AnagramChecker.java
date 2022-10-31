import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String s1 = scanner.nextLine();
		System.out.print("Enter another word: ");
		String s2 = scanner.nextLine();

		if(isAnagram(s1, s2))
			System.out.println(s1 + " and " + s2 + " are anagrams");
		else
			System.out.println(s1 + " and " + s2 + " are not anagrams");

		scanner.close();
	}

	public static boolean isAnagram(String s1, String s2)
	{
		return Arrays.equals(toSortedArray(s1), toSortedArray(s2));
	}

	public static char[] toSortedArray(String s)
	{
		char[] chars = s.toLowerCase().toCharArray();
		Arrays.sort(chars);
		return chars;
	}
}
