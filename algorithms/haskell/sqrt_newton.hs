sqroot :: Double -> Double

sqroot n = (iterate (\a -> (a+n/a)/2) 1.0)!!(length (takeWhile (>0.00001) [((iterate (\a -> (a+n/a)/2) 1.0)!!(k+1))-((iterate (\a -> (a+n/a)/2) 1.0)!!k) | k <- [0..]])+1)
