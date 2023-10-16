#include <iostream>

int main() {
    char op;
    double num1, num2;

    std::cout << "Enter an operator (+, -, *, /): ";
    std::cin >> op;

    std::cout << "Enter two numbers: ";
    std::cin >> num1 >> num2;

    switch (op) {
        case '+':
            std::cout << num1 + num2 << std::endl;
            break;
        case '-':
            std::cout << num1 - num2 << std::endl;
            break;
        case '*':
            std::cout << num1 * num2 << std::endl;
            break;
        case '/':
            if (num2 != 0) {
                std::cout << num1 / num2 << std::endl;
            } else {
                std::cout << "Error: Division by zero!" << std::endl;
            }
            break;
        default:
            std::cout << "Invalid operator" << std::endl;
            break;
    }

    return 0;
}
