#include <iostream>
#include <string>

int main() {
    std::string name1, name2;
    
    // Input names
    std::cout << "Enter the first name: ";
    std::cin >> name1;
    std::cout << "Enter the second name: ";
    std::cin >> name2;

    // Calculate "love score" based on some arbitrary algorithm
    int loveScore = (name1.length() % 10) + (name2.length() % 10);

    std::cout << "\nCalculating love compatibility...\n";

    // Simulate some calculations (you can replace this with your own algorithm)
    for (int i = 0; i < 5; i++) {
        loveScore += (i + 1);
    }

    // Output the result
    std::cout << "\nLove Compatibility between " << name1 << " and " << name2 << ": " << loveScore << "%" << std::endl;

    return 0;
}
