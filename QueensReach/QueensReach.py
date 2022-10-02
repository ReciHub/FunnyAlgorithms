
#Problem: QueensReach, made by SiddharthChaberia
# This code takes the size of the n*n board and the initial position of a chess queen as inputs, and returns how many boxes can it cover from the current positions, given that their is just that queen on the whole board
# This code is funny as it wont really help in any real life problem because u cant play with just a single queen with no opponents obstructing XD
# Hopefully my contribution also gets accepted and becomes a part of Hacktober 2022 fest ✨

def queensreach(n,pos):  
    up=n-pos[0]                                                  # considering the blocks above the queen
    down=pos[0]-1                                                # considering the blocks below the queen
    left=pos[1]-1                                                # considering the block on left side of the queen
    right=n-pos[1]                                               # considering the blocks on right side of the queen
    upleft=min(up,left)                                          # considering the blocks on upper left diagonal of the queen
    upright=min(up,right)                                        # considering the blocks on upper right diagonal of the queen
    downright=min(down,right)                                    # considering the blocks on lower right diagonal of the queen
    downleft=min(down,left)                                      # considering the blocks on lower left diagonal of the queen
    scope=up+down+left+right+upleft+upright+downright+downleft
    return scope

n=int(input("Enter the length/breadth of the chessboard: "))
position=[int(i) for i in input("Enter the x and y position of the queen (1-indexed base): ").split()]
output=queensreach(n,position)
print("The queen could cover:",output,"blocks")