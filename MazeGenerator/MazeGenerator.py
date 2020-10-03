import random

# Create a list of [width][height] with borders
def createGrid(width, height):
    grid = []
    for line in range(height):
        grid.append([])
        for colunm in range(width):
            if ((colunm % 2) == 1) and ((line % 2) == 1):
                grid[line].append(0)
            else: grid[line].append(1)
    return grid

# Algorithm Depth First
def gerateMaze(width, height):

    maze = createGrid(width, height)
    grid = createGrid(width, height)

    width_aux = (len(maze[0]) - 1) // 2
    height_aux = (len(maze) - 1) // 2
    visit = [[0] * width_aux + [1] for _ in range(height_aux)] + [[1] * (width_aux + 1)]

    # Algorithm to walk randomly in the maze
    def drunk_walker(x, y):
        visit[y][x] = 1

        # Possibilities
        a = (x - 1, y)
        b = (x + 1, y)
        c = (x, y + 1)
        d = (x, y - 1)
        possibilities = [a, b, c, d]
        
        random.shuffle(possibilities)  # Shuffle the possibilities

        for (xx, yy) in possibilities:
            if visit[yy][xx]:
                continue
            if xx == x:
                maze[max(y, yy) * 2][x * 2 + 1] = 0
            if yy == y:
                maze[y * 2 + 1][max(x, xx) * 2] = 0

            drunk_walker(xx, yy)

    drunk_walker(random.randrange(width_aux), random.randrange(height_aux))

    #Define exit of maze
    max_coord = len(maze) - 1
    maze[max_coord - 1][max_coord] = 0

    #Define start of maze
    maze[max_coord][1] = 0

    return maze

valid_input = False
while (not valid_input):
    size = input("Size: ")

    if (size.isnumeric()):
        valid_input = True
        w = int(size)
        h = int(size)
    else:
        print("Invalid size.")

if (w % 2 == 0):
    w += 1
if (h % 2 == 0):
    h += 1

maze = gerateMaze(w, h)

def color_wall(skk): return("\033[1;90;100m {:2}\033[00m" .format(skk)) 
def color_floor(skk): return("\033[1;107m {:2}\033[00m" .format(skk)) 

for line in maze:
    str_builder = ''
    for item in line:
        if item == 1:
            str_builder += color_wall(item)
        else: 
            str_builder += color_floor(item)
    print(str_builder)
