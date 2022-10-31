function isPrime(number) {
  //to be a prime it must be divided only by himself or by 1

  //1 is not a prime
  if (number == 1) {
    return false;
  }
  else {
    for (let i = 2; i < number; i++) {
      if (number % i == 0){
        return false;
      }
    }
    return true;
  }
}

//making tests

console.log(isPrime(2));
//true

console.log(isPrime(4));
//false

console.log(isPrime(97));
//true

console.log(isPrime(98));
//false
