import turtle
import random

p = [[0, 280], [-242, -140], [242, -140]]
colors = [
    ((255, 0, 0), (0, 69)),
    ((255, 127, 0), (69, 69 * 2)),
    ((255, 255, 0), (69 * 2, 69 * 3)),
    ((0, 255, 0), (69 * 3, 69 * 4)),
    ((0, 0, 255), (69 * 4, 69 * 5)),
    ((75, 0, 130), (69 * 5, 69 * 6)),
    ((148, 0, 211), (69 * 6, 69 * 7))
]

def changeColor(x):
    colorx = (x + 242)
    for i, (color, (start, end)) in enumerate(colors):
        if start <= colorx < end:
            t.pencolor(color)
            break

# Set True for rainbow-colored triangle
rainbow = False

# Initialize turtle
t = turtle.Turtle()
t.hideturtle()
t.speed(0)
t.penup()
t.pencolor('white')

# Initialize screen
s = turtle.getscreen()
s.setup(width=600, height=600)
s.bgcolor('black')

# Draw first 3 points
for i in range(3):
    t.goto(p[i][0], p[i][1])
    t.dot()

# Draw 10000 points
for i in range(10000):
    r = random.randint(0, 2)
    pos = t.pos()
    # Midway points
    x, y = (pos[0] + p[r][0]) / 2, (pos[1] + p[r][1]) / 2
    t.goto(x, y)
    if rainbow:
        changeColor(x)
    t.dot()

turtle.exitonclick()
