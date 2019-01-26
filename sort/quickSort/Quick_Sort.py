from random import randint

def Partition(A, low, high):

    Pivot = A[high-1]
    i = low-1

    for j in range(low, high-1):
        if(A[j] < Pivot):
            i+=1
            A[i], A[j] = A[j], A[i]
    A[i+1], A[high-1] = A[high-1], A[i+1]
    return i+1

def QuickSort(A, low, high):
    if(high-low > 1):
        mid = Partition(A, low, high)
        QuickSort(A, low, mid)
        QuickSort(A, mid+1, high)

A = [randint(-200,200) for i in range(10)]
print("Orignal array = ", *A)
QuickSort(A, 0, len(A))
print(" Sorted array = ", *A)
