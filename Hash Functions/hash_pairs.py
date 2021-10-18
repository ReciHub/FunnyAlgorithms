
# to find count of pairs with given sum.
def getPairsCount(arr, n, sum):

	count = 0 

	for i in range(0, n):
		for j in range(i + 1, n):
			if arr[i] + arr[j] == sum:
				count += 1

	return count


# Driver function
arr = [1, 5, 7, -1, 5]
n = len(arr)
sum = 6
print("Count of pairs is",
	getPairsCount(arr, n, sum))


