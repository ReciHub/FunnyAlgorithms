#include <iostream>

int funnyAlgorithm(int n) {
    if (n == 1) {
        return 0;
    } else if (n % 2 == 0) {
        return n / 2;
    } else {
        return 3 * n + 1;
    }
}

int main() {
    int n;
    std::cout << "Enter an integer: ";
    std::cin >> n;

    while (n > 1) {
        std::cout << n << " ";
        n = funnyAlgorithm(n);
    }
    
    std::cout << "1" << std::endl;
    
    return 0;
}
