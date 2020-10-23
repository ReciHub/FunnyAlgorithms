const isPrime = function(x) {

if(x%2===0 && x!=2 || x%3===0 && x!=3 || x%5===0 && x!=5|| x%7===0 && x!=7 || x%11===0 && x!=11){
  return false;
}
else return true;
}


//Test
console.log(isPrime(5));
console.log(isPrime(10273));
console.log(isPrime(50));
