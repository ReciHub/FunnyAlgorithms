import turtle
import pygame

# Set up the game window
pygame.init()
window = pygame.display.set_mode((600, 600))
pygame.display.set_caption("sajid chutiya")

# Set up the turtle screen
screen = turtle.Screen()
screen.bgcolor("black")
screen.title("sajid chutiya")
screen.setup(600, 600)

# Set up the snake
snake = turtle.Turtle()
snake.speed(0)
snake.shape("square")
snake.color("white")
snake.penup()
snake.goto(0, 0)

# Main game loop
while True:
    # Check for user input
    if pygame.key.get_pressed()[pygame.K_LEFT]:
        snake.setheading(180)
    elif pygame.key.get_pressed()[pygame.K_RIGHT]:
        snake.setheading(0)
    elif pygame.key.get_pressed()[pygame.K_UP]:
        snake.setheading(90)
    elif pygame.key.get_pressed()[pygame.K_DOWN]:
        snake.setheading(270)

    # Move the snake
    snake.forward(10)

    # Update the screen
    pygame.display.update()
