package main

import (
	"fmt"
)

func main() {
	for i := 1;  i<=100; i++ {
		fmt.Print(i, " ->");
		if (i % 3 == 0) {
			fmt.Print(" Fizz");
		}
		
		if (i % 5 == 0) {
			fmt.Print(" Buzz");
		}
		fmt.Println("");
	}
}
