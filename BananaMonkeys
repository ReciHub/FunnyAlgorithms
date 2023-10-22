#include <iostream>
#include <string>
#include <vector>
#include <chrono>
#include <thread>


void pause(int duration)
{
	std::this_thread::sleep_for(std::chrono::milliseconds(duration));
}
int main()
{
	std::string userInput;
	std::vector<std::string> yum{ "Munch.", "Gobble.", "Slurp.", "Chomp.", "Nibble.", "Savor.", 
		"Devour.", "Gnaw.", "Graze.", "Feast.", "Sip", "Swallow.", "Inhale.", "Chew." };

	std::cout << "Do you like bananas? (y/n): ";
	std::getline(std::cin, userInput);

	while (userInput != "y" && userInput != "n")
	{
		std::cout << "Monkey no understand. Do you like bananas? (y/n): ";
		std::getline(std::cin, userInput);

	}

	if (userInput == "y")
	{
		while (1)
		{
			for (int i = 0; i < yum.size(); i++)
			{
				std::cout << "BANANA!!!\n";
				pause(1000);
				std::cout << yum[i] << '\n';
				pause(1000);
			}
		}

	}

	else
	{
		std::cout << "Disgraceful.\n";
	}

	return 0;
}

