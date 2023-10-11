#include <iostream>
#include <math.h>
using namespace std;

void Print_Board(int arr[9][9]) {

	cout << "  --------------------------\n";
	for (int row = 0; row < 9; row++) {
		for (int col = 0; col < 9; col++) {
			if (col == 3 || col == 6 || col == 0)
				cout << " | ";
			cout << arr[row][col] << " ";
			if (col == 8)
				cout << " | ";
		}
		if (row == 2 || row == 5) {
			cout << endl;
			cout << "  --------------------------";
		}
		cout << endl;
	}
	cout << "  --------------------------";
}

//This function checks if the number can be filled in a given cell.
bool isValid(int arr[9][9], int row_index, int col_index, int num) {

	//checking if the num appears in the same row
	for (int j = 0; j < 9; j++) {
		if (j == col_index) {
			continue;
		}

		if (arr[row_index][j] == num) {
			return false;
		}
	}

	//checking if the num appears in the same column
	for (int i = 0; i < 9; i++) {
		if (i == row_index) {
			continue;
		}

		if (arr[i][col_index] == num) {
			return false;
		}
	}

	//checking if the number appears in the block(3x3 matrix)

	//We need to find the starting cell of the block.
	//For this we use the following formulas:
	//row_index-(row_index % sqrt(9)) and col_index - (col_index % sqrt(9))

	int starting_x = row_index - (row_index % 3);
	int starting_y = col_index - (col_index % 3);

	for (int i = starting_x; i < starting_x + 3; i++) {

		for (int j = starting_y; j < starting_y + 3; j++) {
			if (i == row_index && j == col_index) {
				continue;
			}

			if (arr[i][j] == num) {
				return false;
			}
		}
	}

	return true;
}

bool Sudoku_Solver(int arr[9][9], int row_index, int col_index) {

	/*Base Case : we have rows 0 - 8. If the rowindex reaches 9 this means all the rows have been
	filled and the soduku has been solved.
	*/
	if (row_index > 8) {
		Print_Board(arr);
		return true;
	}

	//check if the row has been completed.
	if (col_index > 8) {
		//move to the next row.
		return Sudoku_Solver(arr, row_index + 1, 0);
	}

	//If the cell is already filled.
	if (arr[row_index][col_index] >= 1 && arr[row_index][col_index] <= 9) {
		//move to the next cell.
		return Sudoku_Solver(arr, row_index, col_index + 1);
	}

	//This for loop fills the cell with a number from 1-9 range. 
	for (int i = 1; i < 10; i++) {

		if (isValid(arr, row_index, col_index, i)) {

			arr[row_index][col_index] = i;

			/*After the cell has been filled we move to the next index.
			We make a recursive call in which we increment the column_index.
			*/
			bool next_filled = Sudoku_Solver(arr, row_index, col_index + 1);

			//Now we check if the next cell has been filled.
			if (next_filled) {
				return true;
			}

			/*If the next index isnt filled we won't return True and we get
			to this line. In this line we apply Backtracking and undo the changes.
			*/
			arr[row_index][col_index] = 0;
		}

	}
	//If we dont get any valid answers after running the above 'for' loop we return false.
	return false;

}

//This function checks if a given Sudoku Board is Valid.
bool isvalidSudoku(int arr[9][9]) {

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{

			if (arr[i][j] == 0) {
				continue;
			}

			if (!isValid(arr, i, j, arr[i][j])) {
				return false;
			}

		}
	}
	return true;
}

//This function inputs a Sudoku Board from the user.
void inputBoard(int arr[9][9]) {
	for (int i = 0; i < 9; i++) {

		for (int j = 0; j < 9; j++) {
			cin >> arr[i][j];

		}
	}

}

char user_choice() {
	char choice;

	cout << "Do you want to enter your own sudoku (y/n): ";
	cin >> choice;

	return choice;
}



int main() {

	system("color F4");
	int Sudoku_board[9][9];

	if (user_choice() == 'y') {
		system("cls");

	tryagain:
		cout << "\nEnter the Sudoku Puzzle to be Solved: " << endl;
		inputBoard(Sudoku_board);

		if (isvalidSudoku(Sudoku_board)) {
			cout << endl << "Solved Puzzle:" << endl;
			Sudoku_Solver(Sudoku_board, 0, 0);
		}

		else {
			system("color C0");
			cout << "Invalid puzzle";
			cout << "\nTry again ";
			goto tryagain;
		}
	}

	else {

		system("cls");
		int	Sudoku_board[9][9] = { {3,7,0,0,0,0,0,0,0},
									{0,0,1,0,0,0,0,0,8},
									{0,0,0,0,0,5,0,0,0},
									{0,0,0,0,0,0,0,0,0},
									{1,2,3,4,6,0,0,0,0},
									{0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0},
									{0,0,0,9,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0}
		};

		cout << "Puzzle: " << endl;
		Print_Board(Sudoku_board);

		cout << endl << "Solved Puzzle:" << endl;
		Sudoku_Solver(Sudoku_board, 0, 0);
	}

	return 0;
}
