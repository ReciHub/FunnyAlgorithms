import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UnSort
{
	private static Random rand = new Random();

	public static void main(String[] args)
	{
		Integer[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("  Orignal Array = " + Arrays.toString(array));
		array = unsort(array);
		System.out.println("Un-Sorted Array = " + Arrays.toString(array));
	}

	public static Integer[] unsort(Integer[] array)
	{
		Integer[] toreturn = new Integer[array.length];
		List<Integer> removalList = new ArrayList<Integer>();
		removalList.addAll(Arrays.asList(array));
		for(int i = 0; i < array.length; i++)
		{
			toreturn[i] = removalList.remove(rand.nextInt(removalList.size()));
		}
		return toreturn;
	}
}
