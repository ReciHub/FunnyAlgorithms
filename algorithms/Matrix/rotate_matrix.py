# Python program to rotate a matrix
def rotateMatrix(mat):

	if not len(mat):
		return

	top = 0
	bottom = len(mat)-1

	left = 0
	right = len(mat[0])-1

	while left < right and top < bottom:
		# this element will replace first element of
		prev = mat[top+1][left]

		for i in range(left, right+1):
			curr = mat[top][i]
			mat[top][i] = prev
			prev = curr

		top += 1

		for i in range(top, bottom+1):
			curr = mat[i][right]
			mat[i][right] = prev
			prev = curr

		right -= 1

		for i in range(right, left-1, -1):
			curr = mat[bottom][i]
			mat[bottom][i] = prev
			prev = curr

		bottom -= 1

		for i in range(bottom, top-1, -1):
			curr = mat[i][left]
			mat[i][left] = prev
			prev = curr

		left += 1

	return mat
def printMatrix(mat):
	for row in mat:
		print (row)

matrix =[
			[1, 2, 3, 4 ],
			[5, 6, 7, 8 ],
			[9, 10, 11, 12 ],
			[13, 14, 15, 16 ]
		]

matrix = rotateMatrix(matrix)
printMatrix(matrix)
