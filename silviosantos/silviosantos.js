const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let currentNumber = 0;

const silvioSantos = async (userInput) => {
  currentNumber += 1;
  if (currentNumber % 3 == 0) {
    if (userInput.trim().toLowerCase() != "pin") {
      console.log("Você perdeu, era um pin");
      process.exit(0);
    }
  } else if (userInput.trim().toLowerCase() != currentNumber) {
    console.log(`Você perdeu, era ${currentNumber}`);
    process.exit(0);
  }

  return currentNumber;
};

rl.on("line", silvioSantos);
