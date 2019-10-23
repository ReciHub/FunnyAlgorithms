checkPalindrome :: String -> Bool
checkPalindrome str = str == reverse str

main :: IO ()
main = do
  putStrLn "Please enter a word"
  word <- getLine
  if(checkPalindrome word == True)
    then putStrLn "This word is a palindrome"
    else putStrLn "This word is not a palindrome"
