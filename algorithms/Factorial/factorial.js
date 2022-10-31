const factorial = n => {
  if (n < 1) return 'Choose an integer number greater than 0';
  const interactableArray = Array.from(Array(n));
  return interactableArray.reduce((prev, curr, index) => (prev *= index + 1), 1);
};

console.log(factorial(-2));
console.log(factorial(5));
console.log(factorial(7));
