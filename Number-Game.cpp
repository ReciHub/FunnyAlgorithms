#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    std::srand(static_cast<unsigned>(std::time(0))); // Seed the random number generator
    int secretNumber = std::rand() % 100 + 1; // Generate a random number between 1 and 100
    int guess;
    int attempts = 0;

    std::cout << "Welcome to the Guess the Number game!" << std::endl;

    do {
        std::cout << "Enter your guess: ";
        std::cin >> guess;
        attempts++;

        if (guess < secretNumber) {
            std::cout << "Too low! Try again." << std::endl;
        } else if (guess > secretNumber) {
            std::cout << "Too high! Try again." << std::endl;
        } else {
            std::cout << "Congratulations! You guessed the number in " << attempts << " attempts." << std::endl;
        }
    } while (guess != secretNumber);

    return 0;
}
