package main

import (
	"fmt"
	"strings"
)

func isPalindrome(word string) bool {
	word = strings.ToLower(word)

	for i := 0; i < len(word)/2; i++ {
		if word[i] != word[len(word)-i-1] {
			return false
		}
	}
	return true
}

func main() {
	var word string
	fmt.Print("Input a word: ")
	fmt.Scan(&word)

	if !isPalindrome(word) {
		fmt.Println("Sorry, that's not a palindrome")
	} else {
		fmt.Println("It's a palindrome")
	}
}
