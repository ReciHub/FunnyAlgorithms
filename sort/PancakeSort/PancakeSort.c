#include<stdio.h>


void flip(int arr[], int t) {
    int prev;

    for (int i = 0; i <= t/2; i++) {
        prev = arr[i];
        arr[i] = arr[t-i];
        arr[t-i] = prev;
    }
}

int getMaxIndex(int arr[], int t) {
    int max = arr[0], maxIndex = 0;

    for (int i = 1; i < t; i++) {
        if (arr[i] > max) {
            max = arr[i];
            maxIndex = i;
        }
    }

    return maxIndex;
}

void pancakeSort(int arr[], int length) {
    for (int i = length; i > 1; i--) {
        int maxIndex = getMaxIndex(arr, i);

        flip(arr, maxIndex);
        flip(arr, i - 1);
    }
}

void printArray(int arr[], int length) {
    printf("[");
    for (int i = 0; i < length; i++) {
        printf("%d", arr[i]);
        if (i != length-1) printf(", ");
    }
    printf("]\n");
}

int main () {
    int arr[] = { 10, 4, -1, 4, 0, 2, 6, 1, 7 };
    int length = sizeof(arr)/sizeof(int); 

    pancakeSort(arr, length);
    printArray(arr, length);

    return 0;
}