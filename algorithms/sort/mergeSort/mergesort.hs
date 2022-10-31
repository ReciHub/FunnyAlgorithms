merge :: (Ord a) => [a] -> [a] -> [a]
merge [] xs = xs
merge xs [] = xs
merge (x:xs) (y:ys)
    | (x < y) = x:merge xs (y:ys)
    | otherwise = y:merge (x:xs) ys

splitInHalf :: [a] -> ([a], [a])
splitInHalf xs = (take n xs, drop n xs)
    where n = (length xs) `div` 2

mergesort :: (Ord a) => [a] -> [a]
mergesort xs
    | (length xs) > 1 = merge (mergesort ls) (mergesort rs)
    | otherwise = xs
    where (ls, rs) = splitInHalf xs