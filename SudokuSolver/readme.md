# Sudoku Solver

This is a C++ program for solving Sudoku puzzles. It utilizes a backtracking algorithm to find the solution for a given Sudoku board. The program includes functions for inputting a Sudoku board, checking if the board is valid, solving the Sudoku puzzle, and displaying the results.

## How to Use

1. Run the program, and it will prompt you to choose whether to enter your own Sudoku puzzle or use a predefined one.

   - If you choose to enter your own Sudoku puzzle, you will input the values row by row.
   - If you choose not to enter your own puzzle, a predefined puzzle will be used.

2. The program will validate the Sudoku board to ensure it's solvable.

3. If the board is valid, the program will display the original puzzle and the solved puzzle.

4. If the board is not valid, you will be prompted to try again with a new puzzle.

## Functions

1. `void Print_Board(int arr[9][9])`: Prints the Sudoku board in a user-friendly format.

2. `bool isValid(int arr[9][9], int row_index, col_index, int num)`: Checks if a number can be filled in a given cell without violating Sudoku rules.

3. `bool Sudoku_Solver(int arr[9][9], int row_index, int col_index)`: Recursively solves the Sudoku puzzle using backtracking.

4. `bool isvalidSudoku(int arr[9][9])`: Checks if a given Sudoku board is valid.

5. `void inputBoard(int arr[9][9])`: Inputs a Sudoku board from the user.

6. `char user_choice()`: Prompts the user to choose whether to input their puzzle.

7. `int main()`: The main function where the program execution begins. It lets the user choose to input their puzzle or use a predefined one, validates the input, and then solves the Sudoku puzzle.

## Sample Predefined Puzzle

A sample predefined Sudoku puzzle is included in the code for demonstration.

```cpp
int Sudoku_board[9][9] = {
    {3,7,0,0,0,0,0,0,0},
    {0,0,1,0,0,0,0,0,8},
    {0,0,0,0,0,5,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {1,2,3,4,6,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0},
    {0,0,0,9,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0}
};
