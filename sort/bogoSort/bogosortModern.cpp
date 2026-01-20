#include <iostream>
#include <random>
#include <algorithm>
#include <array>

// Uses C++20 features.

int main(void) {
	std::array a = {9,10,4,3,5,6,8,1,7,2};

	unsigned long long n = 0;
	std::random_device rd;
	std::mt19937 gen(rd());
	while (!std::ranges::is_sorted(a)) {
		std::ranges::shuffle(a, gen);
		++n;
	}

	for (int i : a) {
		std::cout << i << " ";
	}
	std::cout << " (took " << n << " iterations)" << std::endl;
}

