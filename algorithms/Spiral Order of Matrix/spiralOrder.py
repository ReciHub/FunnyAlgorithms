
def rotate(matrix):
    transposed_matrix = zip(*matrix) # transpose the matrix
    return list(map(list, reversed(transposed_matrix)))

[row , cloumn] = list(map(int, raw_input().split()))
matrix = [ [] for x in  range(row)]
for i in range(0,row) :
	matrix[i] = list(map(int, raw_input().split()));

while len(matrix) > 0 :
	for i in range(len(matrix[0])) :
		print matrix[0][i],
	matrix = matrix[1:]
	matrix = rotate(matrix)

# sample input 
# 4 4
# 1 2 3 4 
# 5 6 7 8
# 9 10 11 12 
# 13 14 15 16