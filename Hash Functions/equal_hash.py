# Python3 program to find given two arrays to see if they're equal or not.
def areEqual(arr1, arr2, n, m):


	if (n != m):
		return False

	arr1.sort()
	arr2.sort()

	for i in range(0, n - 1):
		if (arr1[i] != arr2[i]):
			return False

	return True

# Driver Code
arr1 = [3, 5, 2, 5, 2]
arr2 = [2, 3, 5, 5, 2]
n = len(arr1)
m = len(arr2)

if (areEqual(arr1, arr2, n, m)):
	print("Yes")
else:
	print("No")

