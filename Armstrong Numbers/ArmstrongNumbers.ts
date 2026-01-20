/**
 * Function to check whether a given number is an Armstrong Number or not
 */
const armstrongNumber = (num: number): boolean => {
    // Check to see if it meets the conditions
    if (Number.isNaN(num) || num < 0)
        return `${num} is not a valid number.`

    const order = num.toString().length;
    let temp = num;
    let sum = 0;
    while (temp) {
        let digit = temp % 10;
        sum += Math.pow(digit, order);
        temp = Math.floor(temp / 10);
    }

    return (sum === num);
}

// Sample driver code
/*
INPUT:  console.log(armstrongNumber(153));
OUTPUT: true
*/
