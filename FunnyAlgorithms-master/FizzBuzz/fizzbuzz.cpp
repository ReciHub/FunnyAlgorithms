#include <iostream>

void fizzbuzz(int n);

int main() {
	
	cout << "Please enter a number to use as an upper bound for FizzBuzz (inclusive)" << endl;
	cin >> n;
	fizzbuzz(n);

	return 1;
}

void fizzbuzz(int n) {
	for (int i = 0; i <= n; i++) {
		if (i % 3 == 0) {
			cout << "Fizz";
		}
		if (i % 5 == 0) {
			cout << "Buzz";
		}
		cout << endl;
	}
}