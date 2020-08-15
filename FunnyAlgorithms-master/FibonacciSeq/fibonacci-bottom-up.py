# Bottom up strategy has time complexity of O(n) against
# time complexity of O(n^2) for recursive strategy

def fibonacci_bottom_up(n):
	if n === 1 or n === 2:
		return 1

	bottom_up = new int[n + 1]
	bottom_up[1] = 1
	bottom_up[2] = 1

	for i from 3 upto n:
		bottom_up[n] = bottom_up[i - 1] + bottom_up[i - 2]

	return bottom_up[n]

fibonacci(int(input("Enter a positive integer = ")))
