// C program to implement recursive Binary Search
// Array must be sorted prior to calling binarysearch
#include <stdio.h>

// A recursive binary search function. It returns
// location of key element in given array[left....right] is present,
// otherwise -1
int binarySearch(int array[], int left, int right, int key)
{
    if (right >= left)
    {
        int middle = left + (right - left) / 2;

        // If the element is present at the middle itself
        if (array[middle] == key)
            return middle;

        // If element is smaller than middle, then it can only be present in left subarray
        if (array[middle] > key)
            return binarySearch(array, left, middle - 1, key);

        // Else the element can only be present in right subarray
        return binarySearch(array, middle + 1, right, key);
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