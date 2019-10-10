def rotateMatrix(mat,N):
    # Consider all squares one by one
    for x in range(0, int(N/ 2)):

        # Consider elements in group
        # of 4 in current square
        for y in range(x, N - x - 1):
            # store current cell in temp variable
            temp = mat[x][y]

            # move values from right to top
            mat[x][y] = mat[y][N - 1 - x]

            # move values from bottom to right
            mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y]

            # move values from left to bottom
            mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x]

            # assign temp to left
            mat[N - 1 - y][x] = temp
    return mat
n=int(input())
a=[[0 for i in range(0,n)] for j in range(0,n)]
k=1
a[n//2][n-1]=k
k+=1
i=n//2
j=n-1
while k<=(n*n):
    i-=1
    j+=1
    if i==-1 and j!=n:
        i=n-1
    if j==n and i!=-1:
        j=0
    if i==-1 and j==n:
        i=0
        j=n-2
    if a[i][j]!=0:
        j-=2
        i+=1
        if i==-1 and j==n:
            i=0
            j=n-2
    a[i][j]=k
    k+=1
print("Magic Square:")
for i in range(0,len(a)):
    print(*a[i],sep=" ")
b1=a
cal1=rotateMatrix(a,n)
b2=a

print(cal)