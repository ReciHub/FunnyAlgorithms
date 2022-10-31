// Simple recursive fibonacci algorithm that costs
// O(N) time, because each line of ifs are constant costs, and the
// recursive call is linear, and O(N) space;
function fib(x) {
  if (x == 0) return 0;
  if (x == 1) return 1;
  return fib(x - 1) + fib(x - 2);
}

// This part of the code is requested so the user is able to add information
// directly into the console.
const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

readline.question("Fib number: ", (num) => {
  console.log(fib(num));
  readline.close();
});
