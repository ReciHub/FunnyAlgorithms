#include <math.h> 
#include <stdio.h>
#include <stdlib.h>

void Insertion_Sort(int array[], int n) {
    int num, j;
    for (int i = 0; i < n; i++) {
        num = array[i];
        j = i - 1;

        while (j >= 0 && array[j] > num) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = num;
    }

    return;
}

void main() {
    int n = 10;
    int array[n];
    srand(0);

    for (int i = 0; i < n; i++) {
        array[i] = (rand() % 200);
    }

    printf("Original Array: \n");
    for (int i = 0; i < n; i++) printf("%d ", array[i]);

    Insertion_Sort(array, n);

    printf("\nSorted Array: \n");
    for (int i = 0; i < n; i++) printf("%d ", array[i]);

    return;
}