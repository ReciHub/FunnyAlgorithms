const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question(`Enter your text: `, text => {
  words = text.trim().split(" ");
  console.log(`Your text contains ${words.length} words.`);
  readline.close();
});
