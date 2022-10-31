#include <stdio.h>
#include <stdlib.h>

void build_heap(int *array, int length);
void heapify(int *array, int subIndice, int length);

int main(void)
{
    int length, *array, x;
    printf("Choose the length of your array: ");
    scanf("%d", &length);
    printf("Now type your array with numbers and an space between: ");
    array = (int *)malloc(length * sizeof(int));
    for (x = 0; x < length; x++)
        scanf("%d", &array[x]);
    build_heap(array, length);
    for (x = 0; x < length; x++)
        printf(" %d ", array[x]);
    return 0;
}

void build_heap(int *array, int length)
{
    int i, temp;
    for (i = length / 2; i >= 0; i--)
        heapify(array, i, length);

    for (i = length - 1; i > 0; i--)
    {
        temp = array[0];
        array[0] = array[i];
        array[i] = temp;
        heapify(array, 0, i);
    }
}

void heapify(int *array, int subIndice, int length)
{
    int left = 2 * subIndice + 1;
    int right = 2 * subIndice + 2;
    int largest, temp;
    if (left < length && array[left] > array[subIndice])
        largest = left;
    else
        largest = subIndice;

    if (right < length && array[right] > array[largest])
        largest = right;
    if (largest != subIndice)
    {
        temp = array[subIndice];
        array[subIndice] = array[largest];
        array[largest] = temp;
        heapify(array, largest, length);
    }
}
