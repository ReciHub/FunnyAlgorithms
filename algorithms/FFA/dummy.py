from collections import deque
import maze
import time
import FFA
#INITIALIZING MAZE & Sync MAZE:
config_Maze=maze.config_Maze
Maze=maze.Maze
  
#INITIALLIZING FFA
FFA=FFA.FFA

#INITIAL VARIABLES FOR PHASE ONE:
#initial position variables
xp=1
yp=27
#initial FFA Cell number
xv=0
yv=13

#Initializing neighbours
neighbours=deque()

def config_Neighbours(xv,yv):
  #Adding Open Neighbours into the stack instead of the center
  if((yv-1)>-1 and FFA[yv-1][xv]!=0):
      neighbours.append((yv-1,xv))
  if((yv+1)<14 and FFA[yv+1][xv]!=0):
      neighbours.append((yv+1,xv))
  if((xv-1)>-1 and FFA[yv][xv-1]!=0):
      neighbours.append((yv,xv-1))
  if((xv+1)<14 and FFA[yv][xv+1]!=0):
      neighbours.append((yv,xv+1))
  return neighbours

def sync_Maze(yp,xp):
  #Syncronizing Walls in the Current Cell
  config_Maze[yp-1][xp] = Maze[yp-1][xp]
  config_Maze[yp][xp-1] = Maze[yp][xp-1]
  config_Maze[yp][xp+1] = Maze[yp][xp+1]
  config_Maze[yp+1][xp] = Maze[yp+1][xp]
def config_md(yv,xv):
  #Initializing cell values
  north_Value = 100
  south_Value = 100
  west_Value  = 100
  east_Value  = 100
  
  yp_vir=2*(yv)+1
  xp_vir=2*(xv)+1
  print(yp_vir,xp_vir)
  sync_Maze(yp_vir,xp_vir)
  
  #Configuring Open Neighbours to the current Node
  if(config_Maze[yp_vir-1][xp_vir] == " "):
      north_Value = FFA[yv-1][xv]
  if(config_Maze[yp_vir+1][xp_vir] == " "):
      south_Value = FFA[yv+1][xv]
  if(config_Maze[yp_vir][xp_vir-1] == " "):
      west_Value  = FFA[yv][xv-1]
  if(config_Maze[yp_vir][xp_vir+1] == " "):
      east_Value  = FFA[yv][xv+1]
  cell_min=[north_Value,south_Value,west_Value,east_Value]
  cell_min.sort()
  print(cell_min)
  if(cell_min[0]==0):
      md=cell_min[1]
  elif(cell_min[0]!=0):
      md=cell_min[0]
  return md

md=config_md(13,0)
print(md)
neighbours=config_Neighbours(13,0)
print(neighbours)








































































































'''

Maze = [ 
['.', '-', '.', '-', '.', '-', '.', '-', '.', '-', '.'],
['|', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', '|'],
['.', ' ', '.', ' ', '.', '-', '.', '-', '.', ' ', '.'],
['|', ' ', '|', ' ', '|', ' ', ' ', ' ', '|', ' ', '|'],
['.', ' ', '.', ' ', '.', '-', '.', ' ', '.', ' ', '.'],
['|', ' ', '|', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|'],
['.', ' ', '.', ' ', '.', '-', '.', '-', '.', ' ', '.'],
['|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|'],
['.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'],
['|', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|'],
['.', '-', '.', '-', '.', '-', '.', '-', '.', '-', '.'] ]

FFA = [ ['.', '-', '.', '-', '.', '-', '.', '-', '.', '-', '.'],
{'|', 'e', ' ', 'd', ' ', 'c', ' ', 'd', ' ', 'e', '|'],
['.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'],
['|', 'd', ' ', 'c', ' ', 'b', ' ', 'c', ' ', 'd', '|'],
['.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'],
['|', 'c', ' ', 'b', ' ', 'a', ' ', 'b', ' ', 'c', '|'],
['.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'],
['|', 'd', ' ', 'c', ' ', 'b', ' ', 'c', ' ', 'd', '|'],
['.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'],
['|', 'e', ' ', 'd', ' ', 'c', ' ', 'd', ' ', 'e', '|'],
['.', '-', '.', '-', '.', '-', '.', '-', '.', '-', '.'] ];

#Print the Maze
def printMaze():
  i = 0
  j = 0
  while(i < 11):
      print(Maze[j][i],end=' ')
      i+=1
      if(i > 10):
          print("\n")
          j+=1
          i=0
      if(j > 10):
          i=11
          print("\n")
          
#Print the FLOOD FILL ARRAY
def printFFA():
  i = 0
  j = 0
  while(i < 14):
      print(FFA[j][i],end=' ')
      i+=1
      if(i > 13):
          print("\n")
          j+=1
          i=0
      if(j > 13):
          i=14
          print("\n")
          print("\n")
  
      #INITIAL CELL VALUES OF FFA
      north_Value = 100
      south_Value = 100
      west_Value  = 100
      east_Value  = 100

      if(direc=="S"):
      #Syncronize Maze with the config_Maze
          config_Maze[yp-1][xp] = Maze[yp-1][xp]
          config_Maze[yp][xp-1] = Maze[yp][xp-1]
          config_Maze[yp][xp+1] = Maze[yp][xp+1]
          config_Maze[yp+1][xp] = Maze[yp+1][xp]
  
          if(config_Maze[yp-1][xp] == " "):
              north_Value = FFA[yv-1][xv]
          if(config_Maze[yp+1][xp] == " "):
              south_Value = FFA[yv+1][xv]
          if(config_Maze[yp][xp-1] == " "):
              west_Value  = FFA[yv][xv-1]
          if(config_Maze[yp][xp+1] == " "):
              east_Value  = FFA[yv][xv+1]
  
          if(north_Value <= west_Value and north_Value <= east_Value and north_Value != 100):
              direc = "S"
          elif(west_Value <= north_Value and west_Value <= east_Value and west_Value != 100):
              direc = "L"
          elif(east_Value <= north_Value and east_Value <= west_Value and east_Value != 100):
              direc = "R"
          else:
              direc = "D"
      elif(direc == "D"):
          #Syncronize Maze with the config_Maze
          config_Maze[yp+1][xp] = Maze[yp+1][xp]
          config_Maze[yp][xp+1] = Maze[yp][xp+1]
          config_Maze[yp][xp-1] = Maze[yp][xp-1]
          config_Maze[yp-1][xp] = Maze[yp-1][xp]
  
          if(config_Maze[yp+1][xp] == " "):
              south_Value = FFA[yv+1][xv]
          if(config_Maze[yp][xp+1] == " "):
              east_Value = FFA[yv][xv+1]
          if(config_Maze[yp][xp-1] == " "):
              west_Value = FFA[yv][xv-1]
          if(config_Maze[yp-1][xp] == " "):
              north_Value = FFA[yv-1][xv]
  
          if(south_Value <= west_Value and south_Value <= east_Value and south_Value != 100):
              direc = "D"
          elif(east_Value <= south_Value and east_Value <= west_Value and east_Value != 100):
              direc = "R"
          elif(west_Value <= south_Value and west_Value <= east_Value and west_Value != 100):
              direc = "L"
          else:
              direc = "S"
  
      elif(direc == "L"):
          #Syncronize Maze with the config_Maze
          config_Maze[yp+1][xp] = Maze[yp+1][xp]
          config_Maze[yp][xp+1] = Maze[yp][xp+1]
          config_Maze[yp][xp-1] = Maze[yp][xp-1]
          config_Maze[yp-1][xp] = Maze[yp-1][xp]
          
          if(config_Maze[yp][xp-1] == " "):
              west_Value = FFA[yv][xv-1]
          if(config_Maze[yp][xp+1] == " "):
              east_Value = FFA[yv][xv+1]
          if(config_Maze[yp-1][xp] == " "):
              north_Value = FFA[yv-1][xv]
          if(config_Maze[yp+1][xp] == " "):
              south_Value = FFA[yv+1][xv]
          
          if(west_Value <= north_Value and west_Value <= south_Value and west_Value != 100):
              direc = "L"
          elif(north_Value <= west_Value and north_Value <= south_Value and north_Value != 100):
              direc = "S"
          elif(south_Value <= west_Value and south_Value <= north_Value and south_Value != 100):
              direc = "D"
          else:
              direc = "R"
          
      elif(direc == "R"):
          #Syncronize Maze with the config_Maze
          config_Maze[yp+1][xp] = Maze[yp+1][xp]
          config_Maze[yp][xp+1] = Maze[yp][xp+1]
          config_Maze[yp][xp-1] = Maze[yp][xp-1]
          config_Maze[yp-1][xp] = Maze[yp-1][xp]
          
          if(config_Maze[yp][xp+1] == " "):
              east_Value = FFA[yv][xv+1]
          if(config_Maze[yp-1][xp] == " "):
              north_Value = FFA[yv-1][xv]
          if(config_Maze[yp+1][xp] == " "):
              south_Value = FFA[yv+1][xv]
          if(config_Maze[yp][xp-1] == " "):
              west_Value = FFA[yv][xv-1]
          
          if(east_Value <= north_Value and east_Value <= south_Value and east_Value != 100):
              direc = "R"
          elif(south_Value <= east_Value and south_Value <= north_Value and south_Value != 100):
              direc = "D"
          elif(north_Value <= east_Value and north_Value <= south_Value and north_Value != 100):
              direc = "S"
          else:
              direc = "L"
  
      #print the Synchronized MAZE
      maze.printWalls()
      if (xp == 13 and yp == 15):

          print("==========================//END OF SEARCH RUN PHASE 1//==========================")
          return direc,FFA
      else:
          if(direc == "S"):
            if(north_Value >= current_value):
              current_value = north_Value + 1
            FFA[yv][xv] = current_value
            yp = yp - 2
            yv = yv - 1
          elif(direc == "D"):
            if(south_Value >= current_value):
              current_value = south_Value + 1
            FFA[yv][xv] = current_value
            yp = yp + 2
            yv = yv + 1
          elif(direc == "L"):
            if(west_Value >= current_value):
              current_value = west_Value + 1
            FFA[yv][xv] = current_value
            xp = xp - 2
            xv = xv - 1
          elif(direc == "R"):
            if(east_Value >= current_value):
              current_value = east_Value + 1
            FFA[yv][xv] = current_value
            xp = xp + 2
            xv = xv + 1
          current_value = FFA[yv][xv]
'''
