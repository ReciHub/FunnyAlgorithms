import FFA
import phase_One
import maze
import time
from collections import deque

#INITIAL VARIABLES FOR PHASE ONE:
#Initializing neighbours
neighbours=deque()
#initial position variables
xp=1
yp=11
#initial FFA Cell number
xv=0
yv=5

print("INITIALIZING MAZE SIMULATION")
print("\n")

#printing the maze
print("MAZE")
print("\n")
maze.printMaze()
time.sleep(1)

#printing init FFA
print("INTIAL FLOOD FILL ARRAY")
print("\n")
maze.printFFA(FFA.FFA)
time.sleep(2)

#INITIALIZING PHASE ONE
phase_One.phaseOne(yv,xv,yp,xp,FFA.FFA,neighbours)

