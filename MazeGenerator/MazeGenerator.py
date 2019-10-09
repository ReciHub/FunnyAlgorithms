import random
import sys

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

    largura = (len(maze[0]) - 1) // 2
    altura = (len(maze) - 1) // 2
    visit = [[0] * largura + [1] for _ in range(altura)] + [[1] * (largura + 1)]

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
                maze[max(y, yy) * 2][x * 2 + 1] = 1
            if yy == y:
                maze[y * 2 + 1][max(x, xx) * 2] = 1

            drunk_walker(xx, yy)

    drunk_walker(random.randrange(largura), random.randrange(altura))

    max_coord = len(maze) - 1
    maze[max_coord - 1][max_coord] = 0

    return maze

#w = int(input("Width: "))
#h = int(input("Height: "))

w = 21
h = 21

maze = gerateMaze(w, h)

pp = lambda arr: print (*arr, sep="{:4}".format(''))

for line in maze:
    pp(line)

