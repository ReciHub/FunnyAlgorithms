import Data.Char
import Data.List

digits :: Int -> [Int]
digits n = map digitToInt $ show n

stigid :: [Int] -> Int
stigid d = read $ map intToDigit d

smallest :: Int -> Int
smallest = stigid.sort.digits

largest :: Int -> Int 
largest = stigid.reverse.sort.digits

next :: Int -> Int
next n = largest n - smallest n

kSeq :: Int -> [Int]
kSeq n = iterate next n

takeUntilRepeat :: [Int] -> [Int]
takeUntilRepeat a = 
    if length a <= 1 
        then a
        else takeUntilRepeat' a

takeUntilRepeat' :: [Int] -> [Int]
takeUntilRepeat' a = 
    if head a == head (tail a) 
        then [head a]
        else head a : (takeUntilRepeat' $ tail a)

main = do
        print $ take 10 $ kSeq 1235
