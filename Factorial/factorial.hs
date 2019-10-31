factorialIterator :: Int -> Int -> Int -> Int
factorialIterator acc current wanted | current == wanted = (current * acc)
                                     | otherwise = (factorialIterator (current * acc) (current+1) wanted)

factorial :: Int -> Int
factorial x | x < 2 = 1
            | otherwise = (factorialIterator 1 2 x)
