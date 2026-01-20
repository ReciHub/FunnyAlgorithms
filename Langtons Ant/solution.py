import sys
import time
import os

# Define the possible directions: North, East, South, West
# These directions represent the cardinal points and guide the ant's movement on the grid.
# The ant rotates right or left depending on the color of the cell it is currently on, 
# changing its direction accordingly. 
directions = ['N', 'E', 'S', 'W']

# Corresponding movement vectors for each direction
# This dictionary maps each cardinal direction to a tuple that represents the change in (x, y) coordinates.
# It is used to update the ant's position on the grid based on its current facing direction.
# The grid uses a coordinate system where:
# The x-axis runs horizontally, increasing to the right.
# The y-axis runs vertically, increasing downward.
move = {
    'N': (0, -1), # Moving North decreases the y-coordinate by 1 (upward movement)
    'E': (1, 0),
    'S': (0, 1),
    'W': (-1, 0)
}

def turn_right(current_direction):
    idx = directions.index(current_direction)
    return directions[(idx + 1) % 4]

def turn_left(current_direction):
    idx = directions.index(current_direction)
    return directions[(idx - 1) % 4]

def print_grid(grid, ant_position):
    # Clear the terminal screen
    # This command clears the console output to update the grid display for each iteration.
    # It uses 'cls' for Windows systems and 'clear' for Unix-like systems.
    os.system('cls' if os.name == 'nt' else 'clear')

    # Obtain the grid boundaries
    # This section calculates the minimum and maximum x and y coordinates
    # to determine the visible area of the grid.
    # It ensures that all cells that have been visited or modified, including the ant's current position,
    # are included when printing the grid to the terminal.
    x_positions = [x for x, y in grid.keys()]
    y_positions = [y for x, y in grid.keys()]
    x_positions.append(ant_position[0])
    y_positions.append(ant_position[1])

    min_x = min(x_positions)
    max_x = max(x_positions)
    min_y = min(y_positions)
    max_y = max(y_positions)

    for y in range(min_y, max_y + 1):
        row = ''
        for x in range(min_x, max_x + 1):
            if (x, y) == ant_position:
                row += '🐜'  # Ant representation
            else:
                cell = grid.get((x, y), 'white')
                row += '⬛' if cell == 'black' else '⬜'
        print(row)
    print('\n')

def langtons_ant(steps):
    # Initial position of the ant at the center of the grid
    # The ant starts at coordinates (0, 0) facing North.
    # This central starting point allows equal exploration in all directions.
    x, y = 0, 0
    direction = 'N'

    # The grid is represented as a dictionary with coordinates as keys and colors as values
    # This data structure allows us to model the grid dynamically
    grid = {}

    for step in range(steps):
        color = grid.get((x, y), 'white')

        if color == 'white':
            direction = turn_right(direction)
            grid[(x, y)] = 'black'
        else:
            direction = turn_left(direction)
            grid[(x, y)] = 'white'

        # Move to the next position based on the current direction
        dx, dy = move[direction]
        x += dx
        y += dy

        # Print the grid with the ant's current position
        print_grid(grid, (x, y))
        time.sleep(0.05)  # Control the speed of the simulation

if __name__ == "__main__":
    steps = 2000  # Maximum number of steps for the ant to take
    langtons_ant(steps)
