isEven :: Integer -> Bool
isEven = (==0) . (`mod` 2)

main :: IO()
main = do
    putStrLn "Enter the number: "
    num <- getLine
    if (isEven $ read num) then
        putStrLn("The number is even.")
    else
        putStrLn("The number is odd.")
