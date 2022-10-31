//Checking if the number is perfect or not
function isPerfect(number) {
  let count = 0
  for (let i = 1; i < number; i++) {
    if (number % i === 0) count += i
  }

  if (number === count) return true
  return false
}

// change the checkNumber value to what ever number you want to check.
const checkNumber = 5
const isPerfectNumber = isPerfect(checkNumber)

isPerfectNumber
  ? console.log(`The number (${checkNumber}) is perfect`)
  : console.log(`The number (${checkNumber}) is NOT perfect`)
