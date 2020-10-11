printFizz :: Int -> IO ()
printFizz n
  | n `mod` 15 == 0 = print "Fizzbuzz"
  | n `mod` 3 == 0 = print "Fizz"
  | n `mod` 5 == 0 = print "Buzz"
  | otherwise = print ""

fizzbuzz :: IO ()
fizzbuzz = do
  mapM_ printFizz [1..100]

main :: IO ()
main = fizzbuzz
