#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>

std::string generatePassword(int length) {
    std::string characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
    std::string password;

    std::srand(std::time(0)); // Seed the random number generator

    for (int i = 0; i < length; i++) {
        int index = std::rand() % characters.length();
        password.push_back(characters[index]);
    }

    return password;
}

int main() {
    int length = 12;
    std::string password = generatePassword(length);
    std::cout << password << std::endl;
    return 0;
}
