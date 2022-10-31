package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())
	min := 0
	max := 1
	randomNum := min + rand.Intn(max-min+1)

	if randomNum == 0 {
		fmt.Println("heads")
	} else {
		fmt.Println("tails")
	}
}
