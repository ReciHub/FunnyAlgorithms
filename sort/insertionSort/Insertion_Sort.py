from random import randint

def Insertion_Sort(A):

    for i in range(1, len(A)):
        key = A[i]
        j=i-1
        while(j>=0 and A[j]>key):
            A[j+1] = A[j]
            j-=1
        A[j+1] = key

A = [randint(-100, 100) for i in range(10)]
print("Orignal Array = ", *A)
Insertion_Sort(A)
print(" Sorted array = ", *A)
