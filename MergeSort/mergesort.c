#include <stdio.h>
void merge(int a[], int left, int mid, int right)
{

    int n1 = mid - left + 1;
    int n2 = right - mid;

    int L[n1], M[n2];

    for (int i = 0; i < n1; i++)
        L[i] = a[left + i];
    for (int j = 0; j < n2; j++)
        M[j] = a[mid + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = left;

    while (i < n1 && j < n2)
    {
        if (L[i] <= M[j])
        {
            a[k] = L[i];
            i++;
        }
        else
        {
            a[k] = M[j];
            j++;
        }
        k++;
    }

    while (i < n1)
    {
        a[k] = L[i];
        i++;
        k++;
    }

    while (j < n2)
    {
        a[k] = M[j];
        j++;
        k++;
    }
}

void mergeSort(int a[], int l, int right)
{
    if (l < right)
    {

        int m = l + (right - l) / 2;

        mergeSort(a, l, m);
        mergeSort(a, m + 1, right);

        merge(a, l, m, right);
    }
}

void printArray(int a[], int e)
{
    for (int i = 0; i < e; i++)
        printf("%d ", a[i]);
    printf("\n");
}

int main()
{
    int e;
    int a[e];
    printf("Enter the no of array: ");
    scanf("%d", &e);
    printf("Enter the elements: ");
    for(int i = 0; i < e; i++){
        scanf("%d", &a[i]);
    }
    mergeSort(a, 0, e - 1);

    printf("Sorted array: \n");
    printArray(a, e);
}
