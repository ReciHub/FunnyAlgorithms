from random import randint

def Bubble_Sort(A):
    Flag = 1
    while Flag == 1 :
        Flag = 0
        for j in range(len(A)-1):
            if A[j] > A[j+1] :
                A[j], A[j+1] = A[j+1], A[j]
                Flag = 1

A = [randint(-100,100) for i in range(10)]
print("Orignal array = ", *A)
Bubble_Sort(A)
print(" Sorted array = ", *A)
