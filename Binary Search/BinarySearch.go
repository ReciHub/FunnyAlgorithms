package main

import (
    "fmt"
)

func binarySearch(arr []int, target int) int {
    left, right := 0, len(arr)-1

    for left <= right {
        mid := left + (right-left)/2

        if arr[mid] == target {
            return mid // Element found, return its index
        } else if arr[mid] < target {
            left = mid + 1 // Adjust the left boundary
        } else {
            right = mid - 1 // Adjust the right boundary
        }
    }

    return -1 // Element not found
}

func main() {
    arr := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    target := 6

    result := binarySearch(arr, target)

    if result != -1 {
        fmt.Printf("Element %d found at index %d\n", target, result)
    } else {
        fmt.Printf("Element %d not found in the array\n", target)
    }
}
