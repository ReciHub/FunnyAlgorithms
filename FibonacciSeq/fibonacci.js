var cache = [];

function fibonacci(n) {
  if (n > 1) {
    return fibonacci(n - 1) + fibonacci(n - 2);
  } else {
    return n;
  }
}

function fibonacciWithCache(n) {
  const fib = function(n, p0, p1) {
    if (cache.length > n) return cache[n];
    return n == 1 ? p1 : (cache[n] = fib(n - 1, p1, p0 + p1));
  };

  if (cache.length > n) return cache[n];

  return (cache[n] = fibonacci(n, 0, 1));
}

// Here some performance example ;-)

// console.time("fibonacci(15)");
// const a = fibonacci(15);
// console.timeEnd("fibonacci(15)");

// console.time("fibonacciWithCache(15)");
// const b = fibonacciWithCache(15);
// console.timeEnd("fibonacciWithCache(15)");

// $ node fibonacci.js
// $ fibonacci(15): 0.242ms
// $ fibonacciWithCache(15): 0.142ms
