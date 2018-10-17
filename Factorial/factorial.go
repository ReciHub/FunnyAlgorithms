package main

import "fmt"

func factorial(x uint) uint {
	if x == 0 { return 1 }
	return x * factorial(x-1)
}

func main() {
	x := uint(7)
	fact := factorial(x)
	fmt.Println(fact)
}