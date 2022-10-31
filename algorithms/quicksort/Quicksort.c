#include <stdio.h>
void swap(int *a, int *b)
{
    int x = *a;
    *a = *b;
    *b = x;
}
int Divide(int array[], int l, int h)
{
    int p = array[h];
    int i = (l - 1);
    for (int j = l; j < h; j++)
    {
        if (array[j] <= p)
        {
            i++;
            swap(&array[i], &array[j]);
        }
    }
    swap(&array[i + 1], &array[h]);
    return (i + 1);
}
void Quick(int array[], int l, int h)
{
    if (l < h)
    {
        int pi = Divide(array, l, h);
        Quick(array, l, pi - 1);
        Quick(array, pi + 1, h);
    }
}
void print(int array[], int size)
{
    for (int i = 0; i < size; ++i)
    {
        printf("%d  ", array[i]);
    }
    printf("\n");
}
int main()
{
    int n;
    printf("Enter the number of array: ");
    scanf ("%d", &n);
    int data[n];
    printf("Enter the elments: ");
    for(int i=0; i < n; i++){
        scanf("%d", &data[i]);
    }
    printf("Unsorted Array\n");
    print(data, n);
    Quick(data, 0, n - 1);
    printf("Sorted array in ascending order: \n");
    print(data, n);
}
