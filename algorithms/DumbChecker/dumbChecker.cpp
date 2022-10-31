#include <iostream>

int main()
{
    try 
    {
        int luckyNumber;
        std::cout << "Enter your lucky number : ";
        std::cin >> luckyNumber;

        srand(time(0));
        int randomNumber = rand() % 100;
        std::cout << "You are " << randomNumber << "% dumb!" << std::endl;
    }
    catch (std::exception e) 
    {
        std::cout << "Run again and enter a number dumbA**" << std::endl;
    }
}