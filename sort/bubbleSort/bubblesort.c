#include <stdio.h>

// Swaps two integers
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Bubble sort function
void bubbleSort(int arr[], int arrLen) {
    int i, j;
    
    for (i=0; i<arrLen-1; i++) {
        for (j=0; j<arrLen-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                swap(&arr[j], &arr[j+1]);
            }
        }
    }
}

void main() {
    int arr[50], N, i;
    
    printf("Input the lenght of the array: ");
    scanf("%d", &N);
    
    
    printf("Input the array elements: ");
    for (i=0; i<N; i++) {
        scanf("%d", &arr[i]);
    }
    
    printf("Unsorted array: ");
    for (i=0; i<N; i++) {
        printf("%d ", arr[i]);
    }
    
    printf("\n");
    
    // Using buubleSort function to sort the array
    bubbleSort(arr, N);
    
    printf("Sorted array: ");
    for (i=0; i<N; i++) {
        printf("%d ", arr[i]);
    }    
    printf("\n");
}
