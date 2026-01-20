# use basic principles of rendering 3d graphics unto a 2d screen to make a rotating polyhedrons
import turtle
import time
from math import cos, sin, radians, sqrt

# i like typing random stuff like dotnet/run at the begining if the program
garbage = input()


pen = turtle.Turtle()
pen.hideturtle()
turtle.tracer(0, 0)

# starting settings
X = 0
Y = -60
fps = 25
speed = 200

# shape sizes
size = 40

# list of shape positions
shapePos = [[0, 0], [0, 0]]

# adjust the speed so it moves as the same speed despite fps
speed *= 1 / fps

#Each shape edge takes 6 coordinates: a Vector3 of a the first start and end of the line

#A dodecahedron

# golden ratio
phi = (1 + sqrt(5)) / 2

doEdges = [[1,1,1,phi,1/phi,0]]
doEdges.append([1,1,1,0,phi,1/phi])
doEdges.append([1,1,1,1/phi,0,phi])

doEdges.append([-1,-1,-1,-phi,-1/phi,0])
doEdges.append([-1,-1,-1,0,-phi,-1/phi])
doEdges.append([-1,-1,-1,-1/phi,0,-phi])

doEdges.append([-1,1,1,-phi,1/phi,0])
doEdges.append([-1,1,1,0,phi,1/phi])
doEdges.append([-1,1,1,-1/phi,0,phi])

doEdges.append([1,-1,1,phi,-1/phi,0])
doEdges.append([1,-1,1,0,-phi,1/phi])
doEdges.append([1,-1,1,1/phi,0,phi])

doEdges.append([1,1,-1,phi,1/phi,0])
doEdges.append([1,1,-1,0,phi,-1/phi])
doEdges.append([1,1,-1,1/phi,0,-phi])

doEdges.append([-1,-1,1,-phi,-1/phi,0])
doEdges.append([-1,-1,1,0,-phi,1/phi])
doEdges.append([-1,-1,1,-1/phi,0,phi])

doEdges.append([1,-1,-1,phi,-1/phi,0])
doEdges.append([1,-1,-1,0,-phi,-1/phi])
doEdges.append([1,-1,-1,1/phi,0,-phi])

doEdges.append([-1,1,-1,-phi,1/phi,0])
doEdges.append([-1,1,-1,0,phi,-1/phi])
doEdges.append([-1,1,-1,-1/phi,0,-phi])

doEdges.append([0,phi,1/phi,0,phi,-1/phi])
doEdges.append([0,-phi,1/phi,0,-phi,-1/phi])

doEdges.append([1/phi,0,phi,-1/phi,0,phi])
doEdges.append([1/phi,0,-phi,-1/phi,0,-phi])

doEdges.append([phi,1/phi,0,phi,-1/phi,0])
doEdges.append([-phi,1/phi,0,-phi,-1/phi,0])

for edge in doEdges:
  for point in edge:
    edge[edge.index(point)] *= size

shapes = [doEdges]

def drawLine2D(edge, center):
    #turns the Vector3 into a Vector2 using the oblique projection  
    print(edge) 
    x2D_start = edge[0] + edge[2] * cos(radians(45)) + center[0]
    y2D_start = edge[1] - edge[2] * sin(radians(45)) + center[1]
    x2D_end = edge[3] + edge[5] * cos(radians(45)) + center[0]
    y2D_end = edge[4] - edge[5] * sin(radians(45)) + center[1]
    pen.penup()
    pen.goto(x2D_start, y2D_start)
    pen.pendown()
    pen.goto(x2D_end, y2D_end)


def startGame():
    global X, Y, shapePos

    for s in shapes:
        for shapeEdge in s:

            edge = [
                shapeEdge[0], shapeEdge[1], shapeEdge[2], shapeEdge[3],
                shapeEdge[4], shapeEdge[5]
            ]
            #Rotates the Vector3 around the x axis using the rotation matrix formula
            y = edge[1]
            z = edge[2]
            edge[1] = y * cos(radians(Y)) - z * sin(radians(Y))
            edge[2] = y * sin(radians(Y)) + z * cos(radians(Y))
            y = edge[4]
            z = edge[5]
            edge[4] = y * cos(radians(Y)) - z * sin(radians(Y))
            edge[5] = y * sin(radians(Y)) + z * cos(radians(Y))

            #Rotates the Vector3 around the y axis using the rotation matrix formula
            z = edge[2]
            x = edge[0]
            edge[2] = z * cos(radians(X)) - x * sin(radians(X))
            edge[0] = z * sin(radians(X)) + x * cos(radians(X))
            z = edge[5]
            x = edge[3]
            edge[5] = z * cos(radians(X)) - x * sin(radians(X))
            edge[3] = z * sin(radians(X)) + x * cos(radians(X))
            #draw the new line based on the calculations
            drawLine2D(edge, shapePos[shapes.index(s)])


while True:
    #make the speed smooth and consistent
    time.sleep(1 / fps)

    # clear old cube
    pen.clear()

    # move rotation and update calculations and screen
    X += speed
    startGame()

    turtle.update()

wn = turtle.Screen()
wn.mainloop()