-- Luis L Reyes
-- fibonacci function takes in the nth number
-- of the sequence you want where sequence
-- is zero while n = 0 or 1
module Fibonacci where
    fibonacci :: Integer -> Integer
    fibonacci 0 = 1
    fibonacci 1 = 1
    fibonacci n = (fibonacci (n-1)) + (fibonacci(n-2));