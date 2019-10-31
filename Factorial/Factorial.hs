-- Luis L Reyes
-- Simple factorial function
module Factorial where
factorial :: Integer -> Integer
factorial 1 = 1
factorial n = n * (factorial (n-1))