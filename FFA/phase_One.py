#SEARCH AlGORITHM PHASE ONE:SEARCH FOR THE CENTER
import maze
import sys

sys.setrecursionlimit(5000)
#INITIALIZING MAZE & Sync MAZE:
config_Maze=maze.config_Maze
Maze=maze.Maze
  
def check_Mid(yp,xp,xv,yv,FFA):
      sync_Maze(yp,xp)
      if((config_Maze[yp-1][xp]==' ' and FFA[yv-1][xv]==0) or (config_Maze[yp+1][xp]==' ' and FFA[yv+1][xv]==0) or (config_Maze[yp][xp-1]==' ' and FFA[yv][xv-1]==0) or (config_Maze[yp][xp+1]==' ' and FFA[yv][xv+1]==0)):
                yp=7
                xp=7
      return yp,xp
def sync_Maze(yp_vir,xp_vir):
  #Syncronizing Walls in the Current Cell
  config_Maze[yp_vir-1][xp_vir] = Maze[yp_vir-1][xp_vir]
  config_Maze[yp_vir][xp_vir-1] = Maze[yp_vir][xp_vir-1]
  config_Maze[yp_vir][xp_vir+1] = Maze[yp_vir][xp_vir+1]
  config_Maze[yp_vir+1][xp_vir] = Maze[yp_vir+1][xp_vir]

def config_md(yv,xv,FFA):
  #Initializing cell values
  north_Value = 100
  south_Value = 100
  west_Value  = 100
  east_Value  = 100
  
  yp_vir=2*(yv)+1
  xp_vir=2*(xv)+1
  
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
  if(cell_min[0]==0):
      md=cell_min[1]
  elif(cell_min[0]!=0):
      md=cell_min[0]
  return md

def update_Distance(md,xv,yv,FFA):
  FFA[yv][xv]=md+1
   
def config_Neighbours(xv,yv,FFA,neighbours):

  #Adding Open Neighbours into the stack instead of the center
  if((yv-1)>-1 and FFA[yv-1][xv]!=0):
      neighbours.append((yv-1,xv))
  if((yv+1)<6 and FFA[yv+1][xv]!=0):
      neighbours.append((yv+1,xv))
  if((xv-1)>-1 and FFA[yv][xv-1]!=0):
      neighbours.append((yv,xv-1))
  if((xv+1)<6 and FFA[yv][xv+1]!=0):
      neighbours.append((yv,xv+1))
  return neighbours

def stack_Update(current_value,md,xv,yv,yp,xp,FFA,neighbours):
    
  if(current_value-1!=md):
      update_Distance(md,xv,yv,FFA)
      open_neighbours=config_Neighbours(xv,yv,FFA,neighbours)
      location=open_neighbours.pop()
      yv=location[0]
      xv=location[1]
      current_value=FFA[yv][xv]
      config_Maze[yp][xp]='M'
      maze.printWalls()
      config_Maze[yp][xp]=' '
      phaseOne(yv,xv,yp,xp,FFA,open_neighbours)
  elif(current_value-1==md):
        if(len(neighbours)!=0):
            location=neighbours.pop()
            yv=location[0]
            xv=location[1]
            current_value=FFA[yv][xv]
            config_Maze[yp][xp]='M'
            maze.printWalls()
            config_Maze[yp][xp]=' '
            phaseOne(yv,xv,yp,xp,FFA,neighbours)
        elif(len(neighbours)==0):
            #Initializing cell values
            north_Value = 100
            south_Value = 100
            west_Value  = 100
            east_Value  = 100
            
            yv=int(yp-((yp+1)/2))
            xv=int(xp-((xp+1)/2))
            sync_Maze(yp,xp)

            if(config_Maze[yp-1][xp] == " "):
                north_Value = FFA[yv-1][xv]
            if(config_Maze[yp+1][xp] == " "):
                south_Value = FFA[yv+1][xv]
            if(config_Maze[yp][xp-1] == " "):
                west_Value  = FFA[yv][xv-1]
            if(config_Maze[yp][xp+1] == " "):
                east_Value  = FFA[yv][xv+1]
            if(north_Value <= west_Value and north_Value <= east_Value and north_Value<=south_Value and north_Value != 100):
                current_value=north_Value
                yp=yp-2
                yv=int(yp-((yp+1)/2))
            elif(west_Value <= north_Value and west_Value <= east_Value and west_Value<=south_Value and west_Value != 100):
                current_value=west_Value
                xp=xp-2
                xv=int(xp-((xp+1)/2))
            elif(east_Value <= north_Value and east_Value <= west_Value and east_Value<=south_Value and east_Value != 100):
                current_value=east_Value
                xp=xp+2
                xv=int(xp-((xp+1)/2))
            elif(south_Value <= north_Value and south_Value <= west_Value and south_Value<=east_Value and south_Value != 100):
                current_value=south_Value
                yp=yp+2
                yv=int(yp-((yp+1)/2))
            config_Maze[yp][xp]='M'
            maze.printWalls()
            config_Maze[yp][xp]=' '
            yp,xp=check_Mid(yp,xp,xv,yv,FFA)
            phaseOne(yv,xv,yp,xp,FFA,neighbours)

print("==========================//START OF SEARCH RUN PHASE 1(SEARCH FOR CENTER)//==========================")    
def phaseOne(yv,xv,yp,xp,FFA,neighbours):
  #value of the current cell
  current_value = FFA[yv][xv]
  print(neighbours)
  print(len(neighbours))
  maze.printFFA(FFA)    
  print(xp,yp,xv,yv)
  #if the Mouse Reaches the Center END PHASE ONE else CONTINUE SEARCH      
  if(xp==7 and yp==7):
      print('END OF SEARCH PHASE ONE:TARGET REACHED')
      config_Maze[yp][xp]='M'
      maze.printWalls()
      maze.printFFA(FFA) 
      config_Maze[yp][xp]=' '
  else:
      md=config_md(yv,xv,FFA)
      print(current_value)
      print(md)
      stack_Update(current_value,md,xv,yv,yp,xp,FFA,neighbours)

          
        
            
      