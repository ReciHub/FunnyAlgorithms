/**
 * Collatz Conjecture
 * https://en.wikipedia.org/wiki/Collatz_conjecture
 * @param {Number} num 
 */
const collatz = (num) => {
    // Convert the input the Number [Same as: Number(num)]
    num = +num;

    // Check to see if it meets the conditions
    if (isNaN(num) || num < 0) {
        return `${num} is not a valid number.`;
    }

    var count = 0;
    while (num !== 1) {
        if (num % 2) num = 3 * num + 1;
        else num = Math.floor(num / 2);
        count++;
    }

    return count;
}

// Sample driver code
/*
INPUT:  console.log(collatz(9));
OUTPUT: 19
*/