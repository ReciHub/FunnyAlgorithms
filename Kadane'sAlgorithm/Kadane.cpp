/*
 * Kadane's algorithm in C++
 */

#include <iostream>
#include <algorithm>

int Solve(int arr[], int size);

int main() {
	int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	int size = 8;
	std::cout << Solve(arr, size) << std::endl;
	return 0;
}

int Solve(int arr[], int size) {
	
	int max=0, cur=0;
	for(int i=0; i<size; ++i) {
		cur = std::max(arr[i], cur+arr[i]);
		max = std::max(cur, max);
	}
	return max;
}
