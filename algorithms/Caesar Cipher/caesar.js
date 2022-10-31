const alphabet = "abcdefghijklmnopqrstuvwxyz".split(""); //Transform string into array to match letter with position.

let input = window.prompt("Enter a text which should be encoded: ");

let caesarShift = window.prompt("Enter a numerical key: ");

let numCaesar = parseInt(caesarShift); // How many letters to the right should it shift?
let inputNumber = []; // Array containing the clear values of every letter and corresponding place in alphabet
let numbersEncoded = []; // (Clear) Position of letter plus caeasrShift
let encryptedWord = []; // The encrypted word

// III. Transform into secret text

let secretText = () => {
  numbersEncoded.forEach(e => {
    e == -1 ? encryptedWord.push(" ") : encryptedWord.push(alphabet[e]);
  });
  let encryptedOutput = encryptedWord.join("");
  alert("Encrypted message: " + encryptedOutput);
};

// II.) Fuction takes (clear) numerical input. Adds caesarshift. Depending on whether it is a blank (-1) or it exceeds the number 26 (numbers of letters in English alphabet) the value is pushed in array numbersEncoded.

let encodeNumber = (inputNumber, numCaesar) => {
  inputNumber.forEach(e => {
    if (e === -1) {
      numbersEncoded.push(e);
    } else if (e + numCaesar < 26) {
      numbersEncoded.push(e + numCaesar);
    } else {
      numbersEncoded.push(e + numCaesar - 26);
    }
  });

  // Function call to transform encoded numbers into encoded text.
  secretText(numbersEncoded);
};

// I. Transform Word into numerical values corresponding to position in alphabet
input
  .toLowerCase()
  .split("")
  .forEach(e => {
    inputNumber.push(parseInt(alphabet.indexOf(e)));
  });

// Function call to add caesarshift
encodeNumber(inputNumber, numCaesar);
