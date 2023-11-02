import turtle

# Function to draw a Pythagoras Tree
def pythagoras_tree(order, size, angle=90):
    if order == 0:
        turtle.forward(size)
    else:
        size /= (2 ** 0.5)
        turtle.left(angle)
        pythagoras_tree(order - 1, size, angle)
        turtle.right(90)
        pythagoras_tree(order - 1, size, angle)
        turtle.left(angle)
        turtle.backward(size)

# Initialize the Turtle
turtle.speed(0)  # Fastest drawing speed
turtle.penup()
turtle.goto(0, -200)
turtle.pendown()

# Set the order and size of the Pythagoras Tree
order = 5  # You can adjust this to change the level of detail
size = 200

# Draw the Pythagoras Tree
pythagoras_tree(order, size)

# Close the Turtle graphics window on click
turtle.exitonclick()
