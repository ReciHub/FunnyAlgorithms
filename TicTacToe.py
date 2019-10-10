def magic():
    n = 3
    a = [[0 for i in range(0, n)] for j in range(0, n)]
    k = 1
    a[n // 2][n - 1] = k
    k += 1
    i = n // 2
    j = n - 1
    while k <= (n * n):
        i -= 1
        j += 1
        if i == -1 and j != n:
            i = n - 1
        if j == n and i != -1:
            j = 0
        if i == -1 and j == n:
            i = 0
            j = n - 2
        if a[i][j] != 0:
            j -= 2
            i += 1
            if i == -1 and j == n:
                i = 0
                j = n - 2
        a[i][j] = k
        k += 1
    return a
a=magic()
b=[]
comp=[]
human=[]
for i in range(0,9):
    b.append(0)
def pos_win(arr):
    flagh=0 # flag for human win
    for ii in range(0, len(arr)):
        for jj in range(ii + 1, len(arr)):
            for kk in range(jj+1,len(arr)):
                if ((arr[ii] + arr[jj] + arr[kk])==15):
                    flagh=2
                    break
    return flagh
def move_1():
    flag=0
    comp.append(5)
    b[4]=1
    return flag
def move_2():
    flag = 0
    if b[4]==0:
        comp.append(5)
        b[4]=1
    else:
        b[1]=1
        comp.append(2)
    return flag
def move_3():
    flag = 0
    if b[7]==0:
        comp.append(8)
        b[7]=1
    else:
        b[5]=1
        comp.append(6)
    return flag
def move_4():
    flag = 0
    n=15-(human[0]+human[1])
    if n>0 and n<=9 and b[n-1]==0:
        b[n-1]=1
        comp.append(n)
    else:
        done=0
        for i in range(0,len(b)):
            if (i+1)%2!=0 and b[i]==0:
                b[i]=1
                done=1
                comp.append(i+1)
                break
        if done==0:
            for i in range(0,len(b)):
                if b[i]==0:
                    b[i]=1
                    comp.append(i+1)
                    break
    return flag
def move_5():
    flag = 0
    n = 15 - (comp[0] + comp[1])
    m1 = 15 - (human[0] + human[1])
    if n>0 and n<=9 and b[n-1]==0:
        b[n-1]=1
        comp.append(n)
        flag=1
    elif m1>0 and m1<=9 and b[m1-1]==0:
        b[m1-1]=1
        comp.append(m1)
    elif b[3]==0:
        b[3]=1
        comp.append(4)
    else:
        b[5]=1
        comp.append(6)
    return flag
def move_6():
    flag = 0
    n= 15 - (comp[0] + comp[1])
    m1= 15 - (human[0] + human[2])
    m2= 15 - (human[1] + human[2])
    #print(n,m1,m2)
    if n>0 and n<=9 and b[n-1]==0:
        b[n-1]=1
        flag=1
        comp.append(n)
    elif m1>0 and m1<=9 and b[m1-1]==0:
        b[m1-1]=1
        comp.append(m1)
    elif m2>0 and m2<=9 and b[m2-1]==0:
        b[m2-1]=1
        comp.append(m2)
    else:
        done=0
        for i in range(0,len(b)):
            if (i+1)%2!=0 and b[i]==0: # make_2
                b[i]=1
                done=1
                comp.append(i+1)
                break
        if done==0:
            for i in range(0,len(b)):
                if b[i]==0:
                    b[i]=1
                    comp.append(i+1)
                    break
    return flag
def move_7():
    flag = 0
    n1 = 15 - (comp[0] + comp[2])
    n2 = 15 - (comp[2] + comp[1])
    m1 = 15 - (human[0] + human[2])
    m2 = 15 - (human[2] + human[1])
    if n1>0 and n1<=9 and b[n1 - 1] == 0:
        b[n1 - 1] = 1
        comp.append(n1)
        flag = 1
    elif n2>0 and n2<=9 and b[n2 - 1] == 0:
        b[n2 - 1] = 1
        comp.append(n2)
        flag = 1
    elif m1>0 and m1<=9 and b[m1 - 1] == 0:
        b[m1 - 1] = 1
        comp.append(m1)
    elif m2>0 and m2<=9 and b[m2 - 1] == 0:
        b[m2 - 1] = 1
        comp.append(m2)
    else:
        for i in range(0, len(b)):
            if b[i] == 0:
                b[i] = 1
                comp.append(i + 1)
                break
    return flag
def move_8():
    flag = 0
    n1 = 15 - (comp[0] + comp[2])
    n2 = 15 - (comp[2] + comp[1])
    m1 = 15 - (human[0] + human[3])
    m2 = 15 - (human[1] + human[3])
    m3 = 15 - (human[2] + human[3])
    if n1>0 and n1<=9 and b[n1-1]==0:
        b[n1-1]=1
        comp.append(n1)
        flag=1
    elif n2>0 and n2<=9 and b[n2-1]==0:
        b[n2-1]=1
        comp.append(n2)
        flag=1
    elif m1>0 and m1<=9 and b[m1 - 1] == 0:
        b[m1 - 1] = 1
        comp.append(m1)
    elif m2>0 and m2<=9 and b[m2 - 1] == 0:
        b[m2 - 1] = 1
        comp.append(m2)
    elif m3>0 and m3<=9 and b[m3 - 1] == 0:
        b[m3 - 1] = 1
        comp.append(m3)
    else:
        for i in range(0, len(b)):
            if b[i] == 0:
                done=1
                b[i] = 1
                comp.append(i + 1)
                break
    return flag
def move_9():
    flag = 0
    n1 = 15 - (comp[0] + comp[3])
    n2 = 15 - (comp[1] + comp[3])
    n3 = 15 - (comp[2] + comp[3])
    m1 = 15 - (human[0] + human[3])
    m2 = 15 - (human[1] + human[3])
    m3 = 15 - (human[2] + human[3])
    if n1>0 and n1<=9 and b[n1 - 1] == 0:
        b[n1 - 1] = 1
        comp.append(n1)
        flag = 1
    elif n2>0 and n2<=9 and b[n2 - 1] == 0:
        b[n2 - 1] = 1
        comp.append(n2)
        flag = 1
    elif n3>0 and n3<=9 and b[n3 - 1] == 0:
        b[n3 - 1] = 1
        comp.append(n3)
        flag = 1
    elif m1>0 and m1<=9 and b[m1 - 1] == 0:
        b[m1 - 1] = 1
        comp.append(m1)
    elif m2>0 and m2<=9 and b[m2 - 1] == 0:
        b[m2 - 1] = 1
        comp.append(m2)
    elif m3>0 and m3<=9 and b[m3 - 1] == 0:
        b[m3 - 1] = 1
        comp.append(m3)
    else:
        for i in range(0, len(b)):
            if b[i] == 0:
                b[i] = 1
                comp.append(i + 1)
                break
    return flag
def print_board(board):
    print("   |   |   ")
    print(""+board[0]+"  | "+board[1]+" | "+board[2]+" ")
    print("   |   |   ")
    print("---|---|---")
    #print("   |   |   ")
    print("" + board[3] + "  | " + board[4] + " | " + board[5] + " ")
    print("   |   |   ")
    print("---|---|---")
    #print("   |   |   ")
    print("" + board[6] + "  | " + board[7] + " | " + board[8] + " ")
    print("   |   |   ")
arr=[]
for q in range(0,3):
    for u in range(0,3):
        arr.append(a[q][u])
print(" ------   -   -------            ------    --------   -------           ------    --------   --------        \n"
      "/      \ / \ /       \          /      \  /        \ /       \         /      \  /        \ /     ___/        \n"
      " ------  | | |      -            ------   |    _   | |       -          ------   |    _   | |     \            \n"
      "   / \   | | |     /   ______      / \    |  /   \ | |      /  ______     / \    |   / \  | |      \            \n"
      "   | |   | | |     \   \_____\     | |    |  | - | | |      \  \_____\    | |    |   \_/  | |      /             \n"
      "   \ /   \ / \      -              \ /    |  |   | | \       -            \ /    |        | |     /_              \n"
      "    -     -   \_____/               -      \_/    \|  \______/             -      \______/   \______\              \n")
print("Use this magic square to tell the position that you want to choose while playing:")
for i in range(0,len(a)):
    print(*a[i],sep=" ")
print("Enter 0 if you want to start or enter 1 to let computer start the game")
t=int(input())
f=0
board=[]
for i in range(0,9):
    board.append(" ")
#let first player always plays "X"
ansh=""
ansc=""
if t==0:
    ansh="X"
    ansc="O"
else:
    ansh = "O"
    ansc = "X"
for j in range(0,9):
    if (t==0 and j%2==0) or (t==1 and j%2!=0):
        print("Human Plays")
        print("Enter the magic square number")
        s=int(input())
        human.append(s)
        b[s-1]=1
        for q in range(0,9):
            if arr[q]==s:
                board[q]=ansh
                break
        check=pos_win(human)
        #print(human,check)
        if check==2:
            f=2
    else:
        print("Computer Plays")
        if j == 0: f=move_1()
        if j == 1: f=move_2()
        if j == 2: f=move_3()
        if j == 3: f=move_4()
        if j == 4: f=move_5()
        if j == 5: f=move_6()
        if j == 6: f=move_7()
        if j == 7: f=move_8()
        if j == 8: f=move_9()
        l=len(comp)
        s=comp[l-1]
        #print(s)
        for q in range(0,9):
            if arr[q]==s:
                board[q]=ansc
                break
    print_board(board)
    print("Computer's list of moves: ")
    print(comp)
    print("Human's list of moves: ")
    print(human)
    if f==1:
        print("Computer Wins")
        break
    if f==2:
        print("Human Wins")
        break
if f==0:
    print("Draw")
