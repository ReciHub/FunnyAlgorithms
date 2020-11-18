-- Inplementation of a fibonacci sequence in Haskell
-- Calculating the nth number in the sequence
fibonacci :: Integer -> Integer
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2)

-- Generating the first n numbers in the sequence
fibseq :: Integer -> [Integer]
fibseq n = [fibonacci x | x <- [1..n]]
