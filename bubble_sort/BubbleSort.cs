public class Bubble_Sort
{
    static void Main(string[] args)
    {
        int[] arr = { 89, 2, 24, 1002, 4,1,8 };
        int[] sortedArray = BubbleSort(arr);

        foreach(int item in sortedArray)
        {
            Console.WriteLine(item);
        }
        Console.ReadKey();
    }

    /// <summary>
    /// Bubble Sort
    /// </summary>
    /// <param name="arr">Array for sorting</param>
    /// <returns>Sorted array</returns>
    /// <exception cref="Exception">Raise exception if array is null</exception>
    static int[] BubbleSort(int[] arr) { 

        if(arr == null || arr.Length == 0)
        {
            throw new Exception("Passed Array is Invalid");
        }

        if(arr.Length == 1)
        {
            return arr;
        }

        int temp = 0;
        int length = arr.Length;
        bool swapNeeded;

        for (int i = 0 ; i < length; i++) {
            swapNeeded = false;
            
            for (int j = 0 ; j < length - i - 1; j++) {

                if (arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapNeeded = true;
                }
            
            }

            if (!swapNeeded)
            {
                break;
            }
        
        }
        return arr;
    
    
    }
}