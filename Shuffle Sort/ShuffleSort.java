import java.util.Arrays;
import java.util.Random;

public class ShuffleSort
{
	private static Random rand = new Random();

	public static void sort(Integer[] list, boolean verbose)
	{
		/*
		 * A horrible "sorting algorithm" that shuffles the list then check is its sorted if not
		 * shuffles again.There is no guarantee that it will ever finish
		 */

		if(verbose)
			System.out.println(Arrays.toString(list));

		while(!isSorted(list))
		{
			if(verbose)
				System.out.println("... not sorted. about to shuffle");
			shuffle(list);
			if(verbose)
				System.out.println(Arrays.toString(list));
		}
		if(verbose)
			System.out.println("... sorted!");
		else
			System.out.println(Arrays.toString(list));
	}

	public static void shuffle(Integer[] list)
	{
		for(int i = 0; i < list.length * 2; i++)
		{
			int index1 = rand.nextInt(list.length);
			int index2 = rand.nextInt(list.length);
			int temp = list[index1];
			list[index1] = list[index2];
			list[index2] = temp;
		}
	}

	public static boolean isSorted(Integer[] list)
	{
		// check in O(n) if the list is sorted
		for(int i = 0; i < list.length - 1; i++)
			if(list[i + 1] < list[i])
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		Integer[] list = { 1, 5, 4 };
		sort(list, true);
	}
}
