let hcf;
// take input
const number1 = prompt('Enter a first positive integer: ');
const number2 = prompt('Enter a second positive integer: ');
// display the hcf
console.log(`HCF of ${number1} and ${number2} is ${gcd(number1,number2)}.`);
//gcd function
function gcd (a, b) {
    if (!b) {
      return a;
    }
  
    return gcd(b, a % b);
  }
