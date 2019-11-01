const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question(
  `Should I check if it is time to have Beer for Hacktoberfest? (Y / N): `,
  result => {
    result = result.toString().toLowerCase();
    if (result == "y") {
      console.log("It always is beer of clock. Cheers !!!");
    } else if (result == "n") {
      console.log("We check later.");
    } else {
      console.log("Invalid input, try again.");
    }
    readline.close();
  }
);
