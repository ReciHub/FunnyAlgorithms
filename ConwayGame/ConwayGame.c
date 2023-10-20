/*Conway's Game of Life:
Conway's Game of Life is a cellular automaton that simulates the evolution of a grid of cells based on simple rules. It's a fascinating algorithm to implement in C and watch how patterns evolve over time.
c
here:
This program creates a grid of cells and updates their states according to specific rules in each iteration. It uses the <stdio.h>, <stdlib.h>, and <unistd.h> headers for various functions like printf, usleep, and basic standard library functions.
In the main function, an initial grid is created and some cells are initialized as alive (1) to start the simulation. It then accepts how many no of times the pattern has to be displayed via user input ,it then enter into the counter loop where it prints the grid, updates it using updateGrid, and sleeps for 50 milliseconds using usleep to control the speed of the simulation.
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define ROWS 20
#define COLS 20
/*
The printGrid function prints the current state of the grid to the console, displaying "■" for live cells and spaces for dead cells.*/
void printGrid(int grid[ROWS][COLS])
{
    for (int i = 0; i < ROWS; i++)
    {
        for (int j = 0; j < COLS; j++)
        {
            printf(grid[i][j] ? "■ " : "  ");
        }
        printf("\n");
    }
    printf("\n");
}

/*The countNeighbors function calculates the number of live neighbors for a given cell in the grid. It considers the eight adjacent cells.
*/
int countNeighbors(int grid[ROWS][COLS], int x, int y)
{
    int count = 0;
    int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int i = 0; i < 8; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < ROWS && ny >= 0 && ny < COLS)
        {
            count += grid[nx][ny];
        }
    }

    return count;
}
/*The updateGrid function updates the grid based on the rules of Conway's Game of Life. It creates a new grid (newGrid) to store the updated state, and then it iterates through the cells to determine their new state based on the number of live neighbors.*/
void updateGrid(int grid[ROWS][COLS])
{
    int newGrid[ROWS][COLS];

    for (int i = 0; i < ROWS; i++)
    {
        for (int j = 0; j < COLS; j++)
        {
            int neighbors = countNeighbors(grid, i, j);
            if (grid[i][j])
            {
                newGrid[i][j] = (neighbors == 2 || neighbors == 3);
            }
            else
            {
                newGrid[i][j] = (neighbors == 3);
            }
        }
    }

    for (int i = 0; i < ROWS; i++)
    {
        for (int j = 0; j < COLS; j++)
        {
            grid[i][j] = newGrid[i][j];
        }
    }
}

int main()
{
    int grid[ROWS][COLS] = {0}, n;

    // Initialize some cells
    grid[5][5] = 1;
    grid[5][6] = 1;
    grid[6][5] = 1;
    grid[6][7] = 1;
    grid[7][6] = 1;
    printf("Enter How many times you want to see the pattern: ");
    scanf("%d", &n);
    int i = 0;
    while (i < n)
    {
        printGrid(grid);
        updateGrid(grid);
        usleep(50000); // Sleep for 100ms
        i++;
    }

    return 0;
}
