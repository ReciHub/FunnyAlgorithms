/*
Program created by Otacilio Maia (@OtacilioN)
A sort algorithm that the complexity is O(infinity)
It consists in check if the array is sorted, if is not, 
change randomly two numbers in the array, and repeat untill the array is sorted.
It is my own version of the bogoSort algorithm
*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1

char _isSorted(int *array, int length);
void _changeElements(int array[], int length);

int main(void)
{
    int length, index;
    printf("How many numbers do you want to receive?: ");
    scanf("%d", &length);

    // Initialize the array with lenght elements
    int array[length];
    srand(time(NULL));

    // Receive all the elements and store in the array
    for (index = 0; index < length; index++)
        scanf("%d", &array[index]);

    // Prints the array received
    printf("Received %d array:\n", length);
    for (index = 0; index < length; index++)
        printf("%d ", array[index]);

    printf("\nSorting...\n");

    unsigned long long now = time(NULL);
    unsigned long long interaction = 0;

    // Checks if the array is sorted and change 2 elements randomly
    while (!_isSorted(array, length))
    {
        _changeElements(array, length);
        interaction += 1;
    }
    // Prints the array sorted
    printf("Your array is sorted:\n");
    for (index = 0; index < length; index++)
        printf("%d ", array[index]);

    unsigned long long spentTime = time(NULL) - now;

    printf("\nThe time spent to sort was: %llu seconds\n", spentTime);
    printf("Number of interactions: %d\n", interaction);

    return 0;
}

// Returns TRUE if the array is sorted or FALSE otherwise
char _isSorted(int *array, int length)
{
    int index;
    for (index = 0; index < length - 1; index++)
    {
        if (array[index] > array[index + 1])
            return FALSE;
    }
    return TRUE;
}

// Change the place of 2 random numbers
void _changeElements(int *array, int length)
{
    int tmpElement, rand1, rand2;
    rand1 = rand() % length;
    rand2 = rand() % length;
    tmpElement = array[rand1];
    array[rand1] = array[rand2];
    array[rand2] = tmpElement;
}
