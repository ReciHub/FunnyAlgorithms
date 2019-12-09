import Data.List
import System.IO

main :: IO ()
main = return()

{-
The Doomsday algorithm is a simple algorithm used to determine the day of the week for a given date

Besides being really simple to use mentally, making it a cool party trick, it's really interesting

For more info https://en.wikipedia.org/wiki/Doomsday_rule
-}


doomsdayLeap = [4,1,7,4,2,6,4,1,5,3,7,5]
doomsdayNotLeap = [3,7,7,4,2,6,4,1,5,3,7,5]

printWeekday :: Int -> String
printWeekday 0 = "Sunday"
printWeekday 1 = "Monday"
printWeekday 2 = "Tuesday"
printWeekday 3 = "Wednesday"
printWeekday 4 = "Thursday"
printWeekday 5 = "Friday"
printWeekday 6 = "Sunday"

getWeekday :: (Int,Int,Int) -> Int
getWeekday (d,m,y)
-- Return -1 if there's any obvious error in the input
  | (d<1 || d>31) = -1
  | (m<1 || m>12) = -1
  | (y<1990 || y>2019) = -1
  | (m == 2 && d > 29) = -1
-- If there's no error go ahead and calculate the weekday using Doomsday algorithm
  | otherwise = dday
  where dday = (d1 + (d - h)) `mod` 7
        d1 = c4 `mod` 7
        c4 = c1 + c2 + c3 + k
        c3 = c2 `div` 4
        c2 = c0 - (c1 * 12)
        c1 = c0 `div` 12
        c0 = y `mod` 100
        h = getAnchorDay m y
        k = getYearValue y

getYearValue x
  | (x<2000) = 3
  | otherwise = 2

getAnchorDay m y
  | (y `mod` 100 == 0) && not (y `mod` 400 == 0) = doomsdayNotLeap !! (m-1)
  | (y `mod` 4 == 0) = doomsdayLeap !! (m-1)
  | otherwise = doomsdayNotLeap !! (m-1)
