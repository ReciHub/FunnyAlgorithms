// Go program for implementation of Selection Sort 
package main

import "fmt"

func Selection_Sort(arr[] int, size int) []int {
	var min_index int
	var temp int
	for i := 0; i < size - 1; i++ {
	   min_index = i
	   // Find index of minimum element
	   for j := i + 1; j < size; j++ {
		  if arr[j] < arr[min_index] {
			 min_index = j
		  }
	   }
	   temp = arr[i]
	   arr[i] = arr[min_index]
	   arr[min_index] = temp
	}
	return arr
 }

func main() {
	var size = 7
	arr := []int{2,4,3,1,6,8,5}
	fmt.Println(Selection_Sort(arr, size))
}
