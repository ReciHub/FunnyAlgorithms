from random import randint

def Merge(A, start, mid, end):

	Left, Right = A[start:mid], A[mid:end]
	Max = max(Left[-1], Right[-1])+1

	Left.append(Max)
	Right.append(Max)

	i = j = 0
	for count in range(start, end):
		if(Left[i] < Right[j]):
			A[count] = Left[i]
			i+=1
		else:
			A[count] = Right[j]
			j+=1

def Merge_Sort(A, start, end):
	if(start < end-1):
		mid = (start+end)//2
		Merge_Sort(A, start, mid)
		Merge_Sort(A, mid, end)
		Merge(A, start, mid, end)

A = [randint(0,100) for i in range(10)]
print("Orignal array = ", *A)
Merge_Sort(A, 0, len(A))
print(" Sorted array = ", *A)
