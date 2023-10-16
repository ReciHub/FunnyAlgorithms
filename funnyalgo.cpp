#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>

int main() {
    // Seed the random number generator with the current time
    std::srand(std::time(0));

    // Create an array of jokes
    std::vector<std::string> jokes = {
        "Why don't scientists trust atoms? Because they make up everything!",
        "Parallel lines have so much in common. It’s a shame they’ll never meet.",
        "I told my wife she was drawing her eyebrows too high. She looked surprised.",
        "Why don't skeletons fight each other? They don't have the guts.",
        "I used to play piano by ear, but now I use my hands."
    };

    // Generate a random index to select a joke
    int randomIndex = std::rand() % jokes.size();

    // Display the random joke
    std::cout << "Here's a random joke for you:\n";
    std::cout << jokes[randomIndex] << std::endl;

    return 0;
}
