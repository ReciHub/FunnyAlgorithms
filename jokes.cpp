#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    // Seed the random number generator with the current time
    srand(time(0));

    // Array of jokes
    string jokes[] = {
        "Why did the scarecrow win an award? Because he was outstanding in his field!",
        "I'm reading a book on anti-gravity. It's impossible to put down!",
        "Why don't scientists trust atoms? Because they make up everything!",
        "Parallel lines have so much in common. It's a shame they'll never meet.",
        "What do you get when you cross a snowman and a dog? Frostbite!",
        "Did you hear about the mathematician who's afraid of negative numbers? He'll stop at nothing to avoid them!",
        "I used to play piano by ear, but now I use my hands.",
        "Why did the bicycle fall over? Because it was two-tired!",
    };

    int numJokes = sizeof(jokes) / sizeof(jokes[0]);

    while (true) {
        // Generate a random index to select a joke
        int randomIndex = rand() % numJokes;

        // Display the random joke
        cout << "Joke of the day: " << jokes[randomIndex] << endl;

        // Pause for a moment before showing the next joke
        cout << "Press Enter for another joke...";
        cin.ignore();
    }

    return 0;
}
