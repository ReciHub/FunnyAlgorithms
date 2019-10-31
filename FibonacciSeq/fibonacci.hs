lastTwoSum :: [Int] -> Int
lastTwoSum (x:xs) = x + (head xs)


fibonacciRecursive :: [Int] -> Int -> [Int]
fibonacciRecursive (x:xs) z | (length (x:xs) >= z) = (x:xs)
                            | otherwise = (fibonacciRecursive ((x:xs) ++ [(lastTwoSum (reverse (x:xs)))]) z)

fibonacci :: Int -> [Int]
fibonacci x = (fibonacciRecursive [0,1] x)