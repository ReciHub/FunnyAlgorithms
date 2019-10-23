fibonacci :: Integer -> Integer
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci num = fibonacci(num-1) + fibonacci(num-2)

fiblist :: Integer -> [Integer]
fiblist n = map fibonacci [1 .. n]

main :: IO ()
main = do
  putStrLn "Please insert a number"
  input <- getLine
  putStrLn $ show (fiblist (read input :: Integer))
