#include <iostream>
#include <algorithm>
#include <vector>

// Function to compare the choices [0 = tie, -1 = computer win, 1 = user win, -10 = invalid user input]
int compare(std::string &userChoice, std::string& computerChoice) 
{
    if (userChoice == computerChoice) 
    {
        return 0;
    }
    else if (userChoice == "rock") 
    {
        if (computerChoice == "paper") 
        {
            return -1;
        } 
        else 
        {
            return 1;
        }
    }
    else if (userChoice == "paper") 
    {
        if (computerChoice == "scissors") 
        {
            return -1;
        } 
        else 
        {
            return 1;
        }
    }
    else if (userChoice == "scissors") 
    {
        if (computerChoice == "rock") 
        {
            return -1;
        } 
        else 
        {
            return 1;
        }
    }
    else 
    {
        return -10;
    }
}

int main()
{
    int userScore = 0, computerScore = 0;
    std::vector<std::string> choice = {"rock", "paper", "scissors"};

    // Seed for generating different random numbers every time
    srand(time(0));
    
    while (true) 
    {
        // Taking user's choice
        std::cout << "Choose one from rock, paper or scissors  [press q to quit] ";
        std::string userInput;
        std::cin >> userInput;
        std::cout << "\n\n\n";
        
        // Convert entire string to lowercase
        std::transform(userInput.begin(), userInput.end(), userInput.begin(), ::tolower);

        // Check for quit
        if (userInput == "q") 
        {
            break;
        }

        // Generate computer's choice randomly
        std::string computerChoice = choice[rand() % 3];
        
        int result = compare(userInput, computerChoice);

        switch (result)
        {
            case 0:
            {
                std::cout << "It's a tie !" << std::endl;
            } break;
            case 1:
            {
                std::cout << "User wins !!" << std::endl;
                userScore++;
            } break;
            case -1:
            {
                std::cout << "Computer wins !!" << std::endl;
                computerScore++;
            } break;
            case -10:
            {
                std::cout << "Invalid input. Please enter one of rock, paper or scissors" << std::endl;
            } break;
        }
        std::cout << "\n\n=================\nCurrent scores :\nUser : " << userScore << "\nComputer : " << computerScore << "\n=================\n\n";
    }
    std::cout << "\n\n=================\nFinal scores :\nUser : " << userScore << "\nComputer : " << computerScore << "\n=================\n\n"; 
}