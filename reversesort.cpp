#include <iostream>
#include <vector>
#include <algorithm>

// Function to print the elements of a vector
void printVector(const std::vector<int>& vec) {
    for (const auto& num : vec) {
        std::cout << num << " ";
    }
    std::cout << "\n";
}

// ReverseSort algorithm - Sorts the vector in reverse order
void reverseSort(std::vector<int>& vec) {
    std::sort(vec.begin(), vec.end(), std::greater<int>());
}

int main() {
    std::vector<int> numbers = {7, 3, 9, 2, 1, 5};
    
    std::cout << "Original array: ";
    printVector(numbers);
    
    std::cout << "\nApplying ReverseSort...\n";
    reverseSort(numbers);
    
    std::cout << "\nSorted array (in reverse order): ";
    printVector(numbers);
    
    return 0;
}
