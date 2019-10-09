const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question(`Enter a string to reverse: `, str => {
  console.log(reverseString(str));
  readline.close();
});

reverseString = str => {
  return str
    .split("")
    .reverse()
    .join("");
};
