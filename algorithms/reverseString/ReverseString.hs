--Luis L Reyes
-- Reverse a string with recursion

reverseString :: [a] -> [a]
reverseString [] = [];
reverseString (x:xs)= reverseString xs ++ [x]