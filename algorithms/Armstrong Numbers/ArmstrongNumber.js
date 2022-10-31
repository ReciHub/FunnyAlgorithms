/**
 * Function to check whether a given number is 
 * Armstrong number or not
 * @param {Number} num 
 */
const armstrongNumber = (num) => {
    // Convert the input the Number [Same as: Number(num)]
    num = +num;

    // Check to see if it meets the conditions
    if (isNaN(num) || num < 0) {
        return `${num} is not a valid number.`;
    }

    var order = num.toString().length;
    var temp = num;
    var sum = 0;

    while (temp) {
        var digit = temp % 10;

        // [Same as: Math.pow(digit, order)]
        sum += digit ** order;
        
        temp = Math.floor(temp / 10);
    }

    if (sum === num) return `${num} is an Armstrong number.`;
    else return `${num} is NOT an Armstrong number.`;
}

// Sample driver code
/*
INPUT:  console.log(armstrongNumber(153));
OUTPUT: "153 is an Armstrong number."
*/