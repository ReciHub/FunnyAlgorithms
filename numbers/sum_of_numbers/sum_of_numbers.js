// Sum of numbers

const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

function sumOfNumbersIterative(n) {
  let totalSum = 0;
  for (let i = 0; i < n; i++) {
    totalSum = totalSum + (i + 1);
  }
  return totalSum;
}

readline.question("Enter a number: ", (number) => {
  console.log(sumOfNumbersIterative(number));
  readline.close();
});
