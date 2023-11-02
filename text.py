import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation

# Create a figure and axis
fig, ax = plt.subplots()

# Initialize an empty plot
line, = ax.plot([], [], lw=2)

# Set the axis limits
ax.set_xlim(0, 2 * 3.14)
ax.set_ylim(-1, 1)

# Function to initialize the plot
def init():
    line.set_data([], [])
    return line,

# Function to update the plot in each frame
def update(frame):
    x = 2 * 3.14 * frame / 100
    y = 0.5 * (1 + frame / 100)
    line.set_data(x, y)
    return line,

# Create an animation
ani = FuncAnimation(fig, update, frames=100, init_func=init, blit=True)

# Display the animation (this may vary depending on your Python environment)
plt.show()
