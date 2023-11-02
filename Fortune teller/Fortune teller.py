import turtle
import random

# Set up the Turtle screen
wn = turtle.Screen()
wn.bgcolor("black")
wn.title("Crystal Ball Fortune Teller")

# Create a Turtle for drawing the crystal ball
fortune_teller = turtle.Turtle()
fortune_teller.speed(0)  # Maximum speed
fortune_teller.color("white")
fortune_teller.penup()
fortune_teller.hideturtle()

# Create a list of colorful crystal ball colors
ball_colors = ["blue", "purple", "pink", "cyan", "orange"]

# Function to draw a colorful crystal ball
def draw_crystal_ball():
    color = random.choice(ball_colors)
    fortune_teller.goto(0, -100)
    fortune_teller.pendown()
    fortune_teller.begin_fill()
    fortune_teller.color(color)
    fortune_teller.circle(100)
    fortune_teller.end_fill()
    fortune_teller.penup()

# Function to display a humorous fortune message
def tell_fortune():
    fortune_teller.clear()
    draw_crystal_ball()
    messages = [
        "You will discover a hidden talent for interpretive dance.",
        "A friendly alien will invite you to join their intergalactic book club.",
        "Beware of mischievous squirrels trying to steal your socks.",
        "Today is the day you learn to play the accordion - with your nose.",
        "You will invent a groundbreaking recipe - spaghetti ice cream.",
    ]
    fortune = random.choice(messages)
    fortune_teller.color("white")
    fortune_teller.goto(0, -170)
    fortune_teller.write(fortune, align="center", font=("Arial", 14, "normal"))

# Set up the click event
wn.onclick(lambda x, y: tell_fortune())

# Start the Turtle graphics window
wn.mainloop()
