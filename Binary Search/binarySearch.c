// C program to implement recursive Binary Search
// Array must be sorted prior to calling binarysearch
#include <stdio.h>

// A recursive binary search function. It returns
// location of key element in given array[lower_bound....upper_bound] is present,
// otherwise -1
int binarySearch(int array[], int lower_bound, int upper_bound, int key)
{
    if (upper_bound >= lower_bound)
    {
        int pos = (upper_bound - lower_bound)/2
        int middle = lower_bound + pos;

        // If the element is present at the middle itself
        if (array[middle] == key)
            return middle;

        // If element is smaller than middle, then it can only be present in left subarray
        if (array[middle] > key)
            return binarySearch(array, lower_bound, middle - 1, key);

        // Else the element can only be present in right subarray
        return binarySearch(array, middle + 1, upper_bound, key);
    }

    // We reach here when element is not present in array
    return -1;
}

//Driver program to test above function
int main()
{
    int array[] = {2, 3, 4, 10, 40};
    int size = sizeof(array) / sizeof(array[0]);
    int key = 10;
    int result = binarySearch(array, 0, size - 1, key);
    (result == -1) ? printf("Element is not present in array")
                   : printf("Element is present at index %d", result);
    return 0;
}

// The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).

// Output --
// Element is present at index 3
