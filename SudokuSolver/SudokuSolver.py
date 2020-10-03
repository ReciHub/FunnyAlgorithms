import numpy as np

# Checks if an element can be placed at the given location on the grid
def is_correct(grid, i, j, k):

    boxi = (i//3)*3
    boxj = (j//3)*3

    if k in grid[i] or k in grid[:, j]:
        return False

    if k in grid[boxi:boxi+3, boxj:boxj+3]:
        return False

    return True


# Finds an empty space in the grid that can be filled
def find_empty(grid):
    for i in range(9):
        for j in range(9):
            if grid[i][j] == 0:
                return i, j
    return None


# Uses backtracking to solve the puzzle
def solve(grid):

    find = find_empty(grid)

    if not find:
        return True

    i = find[0]
    j = find[1]

    for k in range(1, 10):
        if is_correct(grid, i, j, k) is True:
            grid[i, j] = k

            if solve(grid):
                return True

            grid[i, j] = 0

    return False


# Checks if the user input is correct by:
# 1. Checking if a number in the row is in the range [1,9]
# 2. Checking if number of elements in a row is 9
def check_row(row):
    if len(row) != 9:
        print("Invalid input. Enter row again")
        return False

    for ele in row:
        if ele not in range(10):
            print("Invalid input. Enter row again")
            return False

    return True


# Takes row wise input of the grid from the user
def get_grid():
    grid = []

    for i in range(1, 10):
        row_correct = False

        msg = "Enter Row " + str(i) + " -> "
        while row_correct is not True:
            row = [int(i.strip()) for i in input(msg).split(' ')]
            row_correct = check_row(row)

        grid.append(row)

    return np.array(grid)


# Prints the grid
def print_grid(grid):
    for i in range(9):
        for j in range(9):
            print(grid[i, j], end=' ')
        print()


while True:
    print("****** Sudoku Solver ******")

    print("\nInstructions")
    print("1.Enter the sudoku grid row wise")
    print("2. All the numbers entered must be space separated")
    print("3. Put 0 wherever there is a blank space in the puzzle\n")

    grid = get_grid()
    print("\nYou Entered: ")
    print_grid(grid)

    solve(grid)
    print("\nSudoku solved!")

    print("\nThe solution is: ")
    print_grid(grid)

    ch = ''
    while True:
        ch = input("\nSolve another Puzzle? (Y/N): ").upper()
        if ch not in ['Y', 'N']:
            print("Invalid input. Try again")
        else:
            break

    if ch == 'N':
        print("Bye")
        break
    print("\n")
