import random
import time

def printBoard(board, n):
    for i in range(n):
        for j in range(n):
            print(board[i][j], end=" ")
        print("\n")
    print("\n")

def QueensLasVegas():
    n =8
    board = [[0 for j in range(n)] for i in range(n)] # Gera Board 8x8
    availColumns = []
    for a in range(n):
        availColumns.append(a)
    R = 0
    while len(availColumns)!= 0 and R < n:
        temp = [] 
        for i in availColumns:
            if isSafe(board, R, i):
                temp.append(i)
        if len(temp) == 0:
            return False
        rand = random.choice(temp)
        board[R][rand] = 1
        R += 1
        availColumns.remove(rand)
    printBoard(board, n)
    return 1

def isSafe(board, row, col):
    i = row
    j = col
    while i >= 0 and j >= 0:
        if board[i][j]:
            return False
        i -= 1
        j -= 1
    i = row
    j = col
    while i >= 0 and j < 8:
        if board[i][j]:
            return False
        i = i - 1
        j = j + 1
    return True

i = 0

start_time = time.time()
while True:
    if QueensLasVegas():
        break
    i +=1
elapsed_time = time.time() - start_time
print("Interations: "+str(i))
print("Exec time: "+ str(elapsed_time))