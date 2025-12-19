#include <algorithm>
#include <array>
#include <cassert>
#include <iostream>
#include <optional>
#include <string_view>
#include <tuple>

enum class GameStatus {
  UserWins,
  AIWins,
  Tie,
};

enum class Move { Rock, Paper, Scissors };

// Function to find who wins between user choice and computer choice
GameStatus compare(Move userChoice, Move computerChoice) {
  // 1. If both choices are same, it's a tie
  if (userChoice == computerChoice) return GameStatus::Tie;

  using WinningCombinationsArr = std::array<std::tuple<Move, Move>, 3>;
  constexpr WinningCombinationsArr winning_combinations{
      {{Move::Rock, Move::Scissors},
       {Move::Paper, Move::Rock},
       {Move::Scissors, Move::Paper}}};

  // 2. If given combination found in winning_combinations, user wins
  for (auto [winner, loser] : winning_combinations) {
    if (userChoice == winner && computerChoice == loser)
      return GameStatus::UserWins;
  }

  // 3. Otherwise, lose
  return GameStatus::AIWins;
}

int main() {
  int userScore = 0, computerScore = 0;
  constexpr std::array<Move, 3> choice = {Move::Rock, Move::Paper,
                                          Move::Scissors};

  // Seed for generating different random numbers every time
  srand(static_cast<unsigned>(time(0)));

  std::string userInput;
  while (true) {
    // Taking user's choice
    std::cout << "Choose one from rock, paper or scissors  [press q to quit] ";
    std::cin >> userInput;
    std::cout << "\n\n\n";

    // Convert entire string to lowercase
    std::transform(userInput.begin(), userInput.end(), userInput.begin(),
                   ::tolower);

    // Check for quit
    if (userInput == "q") {
      break;
    }

    // parse user input into enum class Move,
    // if fails then optional doesn't contain value
    auto parse_move = [](std::string_view s) -> std::optional<Move> {
      if (s == "rock") return Move::Rock;
      if (s == "paper") return Move::Paper;
      if (s == "scissors") return Move::Scissors;
      return std::nullopt;
    };

    std::optional<Move> user_move{parse_move(userInput)};

    if (!user_move) {
      std::cout << "Invalid input. Please enter one of rock, paper or scissors"
                << std::endl;
      continue;
    }

    // Generate computer's choice randomly
    Move computer_move{choice[static_cast<unsigned>(rand()) % 3]};

    assert(user_move.has_value() &&
           "parse_move should've caught invalid user move.");

    // Find result from user move and computer move
    GameStatus result = compare(user_move.value(), computer_move);

    switch (result) {
      case GameStatus::Tie: {
        std::cout << "It's a tie !" << std::endl;
      } break;
      case GameStatus::UserWins: {
        std::cout << "User wins !!" << std::endl;
        userScore++;
      } break;
      case GameStatus::AIWins: {
        std::cout << "Computer wins !!" << std::endl;
        computerScore++;
      } break;
    }
    std::cout << "\n\n=================\nCurrent scores :\nUser : " << userScore
              << "\nComputer : " << computerScore << "\n=================\n\n";
  }
  std::cout << "\n\n=================\nFinal scores :\nUser : " << userScore
            << "\nComputer : " << computerScore << "\n=================\n\n";
  return 0;
}
