isItPalindrome :: String -> String
isItPalindrome xs | xs == reverse xs = "It is a palindrome"
                  | otherwise = "It isn't a palindrome"