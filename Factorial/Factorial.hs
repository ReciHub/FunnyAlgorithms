factorial :: Int -> Int
factorial n
  | n < 2 = 1
  | otherwise = foldl (*) 1 [1 .. n]

main :: IO ()
main = do
  putStrLn "Please enter a number"
  input <- getLine
  let number = read input :: Int
  if (number < 0)
    then putStrLn "Number must be positive"
    else print $ "Result: " ++ (show $ factorial number)
