#include <iostream>

int main() 
{
    int number;
    std::cin >> number;
    if (number%2 == 1) 
    {
        std::cout << "Number is odd" << std::endl;
    }
    else 
    {
        std::cout << "Number is even" << std::endl;
    }
    return 0;
}