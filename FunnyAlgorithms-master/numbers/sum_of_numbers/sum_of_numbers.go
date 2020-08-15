package main

import "fmt"

func sum_of_numbers_iterative(n int) int {
	the_sum := 0

	for i := 1; i <= n; i++ {
		the_sum += i
	}

	return the_sum
}

func main() {
	var n int
	fmt.Print("Enter a number: ")
	fmt.Scan(&n)

	fmt.Println(sum_of_numbers_iterative(n))
}
