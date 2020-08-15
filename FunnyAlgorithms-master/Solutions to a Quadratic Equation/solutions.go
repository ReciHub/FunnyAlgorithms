package main

import (
	"fmt"
	"math"
)

func main() {
	var a, b, c float64
	var root1, root2, d float64
	fmt.Println("Given quadratic equation ax^2 + bx + c")
	fmt.Print("Enter a: ")
	fmt.Scan(&a)
	fmt.Print("Enter b: ")
	fmt.Scan(&b)
	fmt.Print("Enter c: ")
	fmt.Scan(&c)

	d = b*b - 4*a*c

	if d > 0 {
		fmt.Println("Roots are real and unequal")
		root1 = (-b + math.Sqrt(d)) / (2 * a)
		root2 = (-b - math.Sqrt(d)) / (2 * a)
		fmt.Println("First root is: ", root1)
		fmt.Println("Second root is: ", root2)
	} else if d == 0 {
		fmt.Println("Roots are real and equal")
		root1 = (-b + math.Sqrt(d)) / (2 * a)
		fmt.Println("Root is: ", root1)
	} else {
		fmt.Println("Roots are imaginary")
	}
}
