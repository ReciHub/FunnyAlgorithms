// C program for implementation of Bubble sort
#include <stdio.h>

// A function for swapping two numbers
void swap(int *num1, int *num2)
{
    int temp = *num1;
    *num1 = *num2;
    *num2 = temp;
}

// A function to implement bubble sort
void bubbleSort(int array[], int size)
{
    int i, j;
    for (i = 0; i < size - 1; i++)
    {
        // Last i elements are already sorted
        for (j = 0; j < size - i - 1; j++)
        {
            if (array[j] > array[j + 1]) // Ascending Array condition to make Decending sort change condition as array[j] < array[j + 1]
            {
                swap(&array[j], &array[j + 1]);
            }
        }
    }
}

/* Function to print an array */
void printArray(int array[], int size)
{
    int i;
    for (i = 0; i < size; i++)
    {
        printf("%d ", array[i]);
    }
    printf("\n");
}

// Driver program to test bubblesort function
int main()
{
    int array[] = {64, 34, 25, 12, 22, 11, 90};
    int size = sizeof(array) / sizeof(array[0]);
    printf("Unsorted array: \n");
    printArray(array, size);
    bubbleSort(array, size);
    printf("Sorted array: \n");
    printArray(array, size);
    return 0;
}
