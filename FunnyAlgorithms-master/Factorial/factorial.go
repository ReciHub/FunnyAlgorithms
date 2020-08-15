package main

import "fmt"

func factorial(x uint) uint {
	if x == 0 { return 1 }   // if x equals 0, returns 1 as neutral multiplication element (and following factorial definition)
	return x * factorial(x-1)// else, returns the current x value times its predecessor
}

func main() {
	x := uint(7)
	fact := factorial(x)
	fmt.Println(fact) // expects 5040 to be printed
}