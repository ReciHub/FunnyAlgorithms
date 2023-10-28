#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

std::vector<std::string> jokeTemplates = {
    "Why did the [animal] [action]? Because it wanted to [pun]!",
    "What do you call a [adjective] [noun]? A [pun]!",
    "Why don't scientists trust atoms? Because they make up everything!",
    "Did you hear about the mathematician who’s afraid of negative numbers? He’ll stop at nothing to avoid them!",
    "I'm on a whiskey diet. I've lost three days already!"
};

std::vector<std::string> animals = {"cat", "dog", "elephant", "chicken", "monkey"};
std::vector<std::string> actions = {"dance", "sing", "jump", "sleep", "laugh"};
std::vector<std::string> adjectives = {"funny", "smart", "happy", "crazy", "lazy"};
std::vector<std::string> nouns = {"clown", "pizza", "robot", "unicorn", "banana"};

std::string getRandomElement(const std::vector<std::string>& vec) {
    int index = rand() % vec.size();
    return vec[index];
}

std::string generateJoke() {
    std::string jokeTemplate = getRandomElement(jokeTemplates);
    std::string animal = getRandomElement(animals);
    std::string action = getRandomElement(actions);
    std::string adjective = getRandomElement(adjectives);
    std::string noun = getRandomElement(nouns);

    size_t posAnimal = jokeTemplate.find("[animal]");
    size_t posAction = jokeTemplate.find("[action]");
    size_t posAdjective = jokeTemplate.find("[adjective]");
    size_t posNoun = jokeTemplate.find("[noun]");

    jokeTemplate.replace(posAnimal, 8, animal);
    jokeTemplate.replace(posAction, 8, action);
    jokeTemplate.replace(posAdjective, 10, adjective);
    jokeTemplate.replace(posNoun, 6, noun);

    return jokeTemplate;
}

int main() {
    // Seed for random number generation
    srand(static_cast<unsigned>(time(0)));

    std::cout << "Here's a random joke for you:\n";
    std::string joke = generateJoke();
    std::cout << joke << std::endl;

    return 0;
}
