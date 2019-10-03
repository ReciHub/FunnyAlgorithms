/*
Beer O Clock in C++
*/

#include <iostream>
#include <string>

void beer();

int main() {
	beer();
	return 0;
}

void beer() {
	std::string ip;
	std::cout << "> Should I check if it is time to have Beer ? (Y / N) ";
	std::cin >> ip;

	if (ip == "N" || ip == "n")
		std::cout << "> We check later" << std::endl;
	else if (ip == "Y" || ip == "y")
		std::cout << "> It always is beer of clock. Cheers !!!" << std::endl;
	else
		std::cout << "> Invalid input, try again." << std::endl;
}