let win = 0;
let loss = 0;

function hangman() {
    let score = 0;

    // Helper function to get lowercase input
    function getInput(prompt) {
        return prompt("Enter your answer: ").toLowerCase();
    }

    // Questions and Answers
    const questions = [
        { question: "What is always coming, but never arrives?", answer: "tomorrow" },
        { question: "What can be broken, but is never held?", answer: "promise" },
        { question: "What lives if it is fed, and dies if you give it a drink?", answer: "fire" },
        { question: "What can one catch that is not thrown?", answer: "cold" },
        { question: "If you have it, you want to share me, and if you share, you do not have it?", answer: "secret" },
        { question: "What goes up and down, but always remains in the same place?", answer: "stairs" },
        { question: "What goes up, but never comes down?", answer: "age" },
        { question: "What word starts with IS, ends with AND, and has LA in the middle?", answer: "island" },
        { question: "If George’s father has four children – Eenie, Meenie, Miney – what is the name of his fourth child?", answer: "george" },
        { question: "Which is the fastest country in the world?", answer: "russia" }
    ];

    // Game Logic
    for (let i = 0; i < questions.length; i++) {
        let userAnswer = getInput(`${i + 1}. ${questions[i].question}`);
        if (userAnswer === questions[i].answer) {
            score++;
            console.log("Correct! Good job!");
        } else {
            console.log("Wrong answer! You just started to hang your man.");
        }

        if (score <= i - 4) {
            loss++;
            console.log("Sorry, but your man dies! You can do better next time!");
            if (confirm("Do you wish to restart again?")) {
                hangman();
            } else {
                exitGame();
            }
        }
    }

    console.log("Your man is alive! Congratulations!");
    let mistakes = questions.length - score;
    win++;
    console.log(`Your score is ${score} and you have made ${mistakes} mistake(s).`);

    if (confirm("Do you wish to restart again?")) {
        hangman();
    } else {
        exitGame();
    }
}

function exitGame() {
    console.log(`You have made ${win} win(s) and ${loss} loss(es).`);
}

console.log("------------------- WELCOME TO HANGMAN BRAVE HUMAN ----------------------\n");
console.log("Let's start the game: \n");
hangman();
