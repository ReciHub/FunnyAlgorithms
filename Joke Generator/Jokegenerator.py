import turtle
import tkinter as tk
import pyjokes

# Initialize turtle graphics window
window = turtle.Screen()
window.title("Joke Generator")
window.bgcolor("lightblue")

# Initialize turtle graphics turtle
joke_turtle = turtle.Turtle()
joke_turtle.hideturtle()
joke_turtle.penup()
joke_turtle.goto(0, 100)
joke_turtle.color("purple")
joke_turtle.write("Welcome to the Joke Generator!", align="center", font=("Arial", 24, "bold"))

# Initialize tkinter window for GUI
root = tk.Tk()
root.title("Joke Generator")
root.geometry("400x200")

# Function to display a new joke
def display_joke():
    joke = pyjokes.get_joke()
    joke_turtle.clear()
    joke_turtle.write(joke, align="center", font=("Arial", 18, "normal"))

# Create "New Joke" button
new_joke_button = tk.Button(root, text="New Joke", command=display_joke, font=("Arial", 14, "bold"))
new_joke_button.pack(pady=20)

# Display the initial joke
display_joke()

# Start the tkinter main loop
root.mainloop()