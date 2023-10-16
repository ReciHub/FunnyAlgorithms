package main

import (
	"fmt"
)

func longestIncreasingSubsequence(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	// Create a dynamic programming array to store the length of the LIS ending at each index
	lis := make([]int, len(nums))
	lis[0] = 1 // Initialize the first element with a length of 1

	maxLength := 1 // Initialize the maximum length to 1

	for i := 1; i < len(nums); i++ {
		lis[i] = 1 // Initialize the length of LIS at index i to 1

		for j := 0; j < i; j++ {
			if nums[i] > nums[j] && lis[i] < lis[j]+1 {
				lis[i] = lis[j] + 1
			}
		}

		if lis[i] > maxLength {
			maxLength = lis[i]
		}
	}

	return maxLength
}

func main() {
	nums := []int{10, 22, 9, 33, 21, 50, 41, 60, 80}
	length := longestIncreasingSubsequence(nums)
	fmt.Println("Length of the longest increasing subsequence:", length)
}
