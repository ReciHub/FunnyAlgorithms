using System.Collections.Generic;
using System.IO;
using System;

public class BubbleSort
{
	private static int numberOfElements;
	private static List<int> elementList = new List<int>();

	BubbleSort()
	{
		numberOfElements = 0;
	}

	public static void GetInput()
	{
		numberOfElements = Convert.ToInt32(Console.ReadLine());
		for(int iterator = 0; iterator < numberOfElements; iterator++)
		{
			int currentValue;
			currentValue = Convert.ToInt32(Console.ReadLine());
			elementList.Add(currentValue);
		}
	}

	public static void Sort()
	{
		for(int iterator = 0; iterator < numberOfElements; iterator++)
		{
			for(int it = 0; it < numberOfElements - iterator - 1; it++)
			{
				if(elementList[it] > elementList[it + 1])
				{
					int temp = elementList[it];
					elementList[it] = elementList[it + 1];
					elementList[it + 1] = temp;
				}
			}
		}
	}

	public static void ShowOutput()
	{
		for(int it = 0; it < numberOfElements; it++)
		{
			Console.Write(elementList[it] + " ");
		}
	}

	public static void Main()
	{
		GetInput();
		Sort();
		ShowOutput();
	}
}
