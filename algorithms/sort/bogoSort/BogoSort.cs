class BogoSort
{
    static void Main(string[] args)
    {
        List<int> list = new List<int>() { 2, 1, 3, 0 };
        Console.WriteLine("BogoSort");
        Console.WriteLine("Sorting...");
        Sort(list);
        Console.WriteLine("Press any key to exit.");
        Console.ReadKey();
    }

    static void Sort(List<int> list)
    {
        int iteration = 0;
        while (!IsSorted(list))
        {
            PrintIteration(list, iteration);
            list = Shuffle(list); //Shuffle the numbers randomly
            iteration++;
        }

        PrintIteration(list, iteration); //Print the final, sorted iteration
        Console.WriteLine();
        Console.WriteLine("BogoSort completed after {0} iterations.", iteration);
    }

    static void PrintIteration(List<int> list, int iteration)
    {
        Console.Write("BogoSort iteration #{0}: ", iteration);
        foreach(var value in list)
        {
            Console.Write($"{value} ");
        }
        Console.WriteLine();
    }
    static bool IsSorted(List<int> list)
    {
        for (int i = 0; i < list.Count - 1; i++)
        {
            if (list[i] > list[i + 1])
            {
                return false;
            }
        }

        return true;
    }

    //Shuffle algorithm based on Fisher-Yates method.
    static List<int> Shuffle(List<int> numbers)
    {
        Random r = new Random();
        //Step 1: For each unshuffled item in the collection
        for (int n = numbers.Count - 1; n > 0; --n)
        {
            //Step 2: Randomly pick an item which has not been shuffled
            int k = r.Next(n + 1);

            //Step 3: Swap the selected item with the last "unstruck" item in the collection
            int temp = numbers[n];
            numbers[n] = numbers[k];
            numbers[k] = temp;
        }
        return numbers;
    }
}
