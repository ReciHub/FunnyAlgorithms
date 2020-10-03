package main

import "fmt"

func BubbleSort(arr []int) {
	var temp int
	var swapFlag bool
	for i := 0; i < len(arr); i++ {
		for j := 0; j < (len(arr) - i - 1); j++ {
			if arr[j] > arr[j+1] {
				temp = arr[j]
				arr[j] = arr[j+1]
				arr[j+1] = temp
				swapFlag = true //if swapping takes place, set swap to true
			}
		}
		if (not swapFlag) { //If swapping was not performed, the array is sorted, break from the loop
			break
		}
	}
}

func printArray(arr []int) {
	for i := 0; i < len(arr); i++ {
		fmt.Print(arr[i], ", ")
	}
}

func main() {
	var length int
	fmt.Print("Enter size of array --> ")
	fmt.Scan(&length)
	var arr = make([]int, length)
	fmt.Print("Enter ", length, " element of array ->")
	for i := 0; i < length; i++ {
		fmt.Scan(&arr[i])
	}
	fmt.Print("Unsorted array -> ")
	printArray(arr)

	fmt.Print("\n Sorted Array -> ")
	BubbleSort(arr)
	printArray(arr)
}
