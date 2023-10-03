import java.util.*

fun getUserChoice(): String {
    while (true) {
        print("Choose rock, paper, or scissors: ")
        val userInput = readLine()?.toLowerCase()
        if (userInput in listOf("rock", "paper", "scissors")) {
            return userInput
        } else {
            println("Invalid choice. Please choose rock, paper, or scissors.")
        }
    }
}

fun getComputerChoice(): String {
    val choices = listOf("rock", "paper", "scissors")
    return choices[Random().nextInt(choices.size)]
}

fun determineWinner(userChoice: String, computerChoice: String): String {
    if (userChoice == computerChoice) {
        return "It's a tie!"
    } else if (
        (userChoice == "rock" && computerChoice == "scissors") ||
        (userChoice == "paper" && computerChoice == "rock") ||
        (userChoice == "scissors" && computerChoice == "paper")
    ) {
        return "You win!"
    } else {
        return "Computer wins!"
    }
}

fun main() {
    println("Welcome to Rock, Paper, Scissors!")
    while (true) {
        val userChoice = getUserChoice()
        val computerChoice = getComputerChoice()

        println("You chose $userChoice")
        println("Computer chose $computerChoice")

        val result = determineWinner(userChoice, computerChoice)
        println(result)

        print("Do you want to play again? (yes/no): ")
        val playAgain = readLine()?.toLowerCase()
        if (playAgain != "yes") {
            break
        }
    }
}
