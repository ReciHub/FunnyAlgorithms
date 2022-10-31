#include <iostream>
#define SIZE 4

void largestOfArr(int arr[][SIZE], int* res) {
	const int arrLength = sizeof arr[0] / sizeof(int);

	for (int n = 0; n < arrLength; n++) {
		int largestNum = arr[n][0];

		for (int sb = 1; sb < SIZE; sb++) {
			if (arr[n][sb] > largestNum) {
				largestNum = arr[n][sb];
			}
		}
		res[n] = largestNum;
	}
}

int main() {
	int arr[][SIZE] = { {5, 3, 4, 1}, {18, 22, 13, 29}, {35, 31, 41, 52}, {1016, 100, 3540, 36} };
	const int arrLength = sizeof arr[0] / sizeof(int);
	int* result = new int[arrLength];

	largestOfArr(arr, result);

	for (int i = 0; i < arrLength; i++) {
		std::cout << result[i] << " ";
	}

	delete[] result;
	return 0;
}