#Library to clear screen on every step
import os
import sys

def instructions():
    os.system('cls')
    print("TIC-TAC-TOE \n                 ")
    print("Instructions To Play           ")
    print("Player 1: X                    ")
    print("Player 2: O                    ")
    print("To Exit: Press 0               ")
    print("To Restart: Spacebar and Enter ")
    print("To Play: Use Digits 1 to 9 and Press Enter")


board = [" "," "," "," "," "," "," "," "," "]

def draw_board(board):
    
    def one_box(k,board,n):
        v1 = '  |'+str(n)+'      |'+str(n+1)+'      |'+str(n+2)+'      |'
        v2='  |       |       |       |'
        h = '   ------- ------- ------- '
        print(h)
        print(v1)
        print('  |   ' + board[k-1]+'   |   '+board[k]+'   |   '+board[k+1]+'   |')
        print(v2)
       
    one_box(k=1,board = board,n=7)
    one_box(k=4,board = board,n=4)
    one_box(k=7,board = board,n=1)
    h = '   ------- ------- ------- '
    print(h)


#To set which player starts the game(X or O) 
i=1

def draw_X(p,board):
    board[p]="X"
    instructions()
    print("\nPlayer 2")
    draw_board(board)
    
def draw_O(p,board):
    board[p]="O"
    instructions()
    print("\nPlayer 1")
    draw_board(board)
    
flag =0
def draw_mark(p,t,board): #p for position, t for player(i)
    global i
    global flag
    if board[p]==" ":
        flag+=1
        if t==1:
            draw_X(p,board)
            i=0
            
        elif t==0:
            draw_O(p,board)
            i=1

enter_count = 0

def win_h(m):
    global enter_count
    if board[m]==board[m+1]==board[m+2]:
        if board[m]=='X':
            print("Player 1 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
        elif board[m]=='O' :
            print("Player 2 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
                
def win_v(m):
    global enter_count
    if board[m]==board[m+3]==board[m+6]:
        if board[m]=='X':
            print("Player 1 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
        elif board[m]=='O' :
            print("Player 2 wins")
            print("Press Spacebar to Continue")
            enter_count+=1

def win_d1(m):
    global enter_count
    if board[m]==board[m+4]==board[m+8]:
        if board[m]=='X':
            print("Player 1 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
        elif board[m]=='O' :
            print("Player 2 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
            
def win_d2(m):
    global enter_count
    if board[m]==board[m+2]==board[m+4]:
        if board[m]=='X':
            print("Player 1 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
        elif board[m]=='O' :
            print("Player 2 wins")
            print("Press Spacebar to Continue")
            enter_count+=1
    elif flag==9:
        print("Match Draw")
        print("Press Spacebar to Restart")


instructions()
print("\nPlayer 1")
draw_board(board)

#position = input("Enter Position:")

while True:
    
    position  = input("Enter Position:")
    sys.stdout.write("\033[F") 
    #on enter Game restarts
    if position == " ":
        i=1
        board = [" "," "," "," "," "," "," "," "," "]
        instructions()
        print("\nPlayer 1")
        draw_board(board)
        enter_count=0

        
    elif position == '0':
        break

    elif enter_count!=1:
        if position == '7' :
            draw_mark(0,i,board)
            flag2 = 70
        elif position == '8':
            draw_mark(1,i,board)
            flag2 = 80
        elif position == '9':
            draw_mark(2,i,board)
            flag2 = 90
        elif position == '4':
            draw_mark(3,i,board)
            flag2 = 40
        elif position == '5':
            draw_mark(4,i,board)
            flag2 = 50
        elif position == '6':
            draw_mark(5,i,board)
            flag2 = 60
        elif position =='1':
            draw_mark(6,i,board)
            flag2 = 10
        elif position == '2':
            draw_mark(7,i,board)
            flag2 = 20
        elif position == '3':
            draw_mark(8,i,board)
            flag2 = 30
        

        win_h(0)
        win_h(3)
        win_h(6)
        win_v(0)
        win_v(1)
        win_v(2)
        win_d1(0)
        win_d2(2)
    
    


