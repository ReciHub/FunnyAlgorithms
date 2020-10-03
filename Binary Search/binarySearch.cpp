#include <bits/stdc++.h>
using namespace std;
 
int binarySearchInd(vector<int> &a, int num) {
	int low = 0, high = a.size() - 1;
	while (low <= high) {
		int mid = (low + high) / 2;
		if (a[mid] == num) {
			return mid;
		}
		if (a[mid] < num) {
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}
	return -1;
}
 
int main() {
	vector<int> a {1, 3, 5, 8, 9, 34, 56};
	cout << "This program will print the index of element given. If not found, will print -1.." << endl;
	cout << "Finding index of 100: " << binarySearchInd(a, 100) << endl;
	cout << "Finding index of 9: " << binarySearchInd(a, 9) << endl;
}