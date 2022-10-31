#include <iostream>

void fizzbuzz(int n);

int main() {

	unsigned int n;

	std::cout << "Please enter a number to use as an upper bound for FizzBuzz "
		   		 "(inclusive)"
			  << std::endl;
	std::cin >> n;
	fizzbuzz(n);

	return 1;
}

void fizzbuzz(int n) {
	std::string res;
	for (int i = 1; i <= n; i++) {
		res = "";
		if (i % 3 == 0)
			res += "Fizz";
		if (i % 5 == 0)
			res += "Buzz";
		if (res == "")
			std::cout << i << std::endl;
		else
			std::cout << res << std::endl;
	}
}
