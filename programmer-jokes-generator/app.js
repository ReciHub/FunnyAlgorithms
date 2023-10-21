const jokes = [
    {
        question: "Why do programmers prefer iOS development over Android development?",
        answer: "Because it's less Java!",
    },
    {
        question: "How do you comfort a JavaScript bug?",
        answer: "You console it!",
    },
    {
        question: "Why do programmers always mix up Christmas and Halloween?",
        answer: "Because Oct 31 == Dec 25!",
    },
    {
        question: "Why did the developer go broke?",
        answer: "Because he used up all his cache!",
    },
    {
        question: "How many programmers does it take to change a lightbulb?",
        answer: "None. It's a hardware problem.",
    },
    {
        question: "Why did the programmer go broke?",
        answer: "Because he lost all his cache!",
    },
    {
        question: "Why do programmers prefer iOS development over Android?",
        answer: "Because it's easier to make iOS developers laugh!",
    },
    {
        question: "How do you comfort a JavaScript bug?",
        answer: "You give it some debugging hugs!",
    },
    {
        question: "Why do programmers hate nature?",
        answer: "It has too many bugs!",
    },
    {
        question: "What do you call a programmer from Finland?",
        answer: "Nerdic!",
    },
    {
        question: "Why was the JavaScript developer sad?",
        answer: "Because he didn't get callbacks!",
    },
    {
        question: "Why don't programmers like to go outside?",
        answer: "The sunlight causes too many reflections!",
    },
    {
        question: "How do you comfort a Java bug?",
        answer: "You tell it to catch itself!",
    },
    {
        question: "Why did the database administrator leave his wife?",
        answer: "Because he had one-to-many relationships!",
    },
];

const jokeText = document.getElementById("joke");
const answerText = document.getElementById("answer");
const generateJokeButton = document.getElementById("generateJoke");
const showAnswerButton = document.getElementById("showAnswer");

generateJokeButton.addEventListener("click", () => {
    const randomIndex = Math.floor(Math.random() * jokes.length);
    jokeText.textContent = jokes[randomIndex].question;
    answerText.textContent = ''; // Clear the answer
    answerText.classList.add("hidden");
});

showAnswerButton.addEventListener("click", () => {
    answerText.textContent = jokes.find(joke => joke.question === jokeText.textContent).answer;
    answerText.classList.remove("hidden");
});
