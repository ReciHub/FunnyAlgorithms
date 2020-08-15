// We'll write an iterative binary search function in javascript
// If the number searched is in the array, it'll return its position
// Otherwise, it'll return -1

// Usually, the iterative mode uses less memory than the recursive one
// because it doesn't need to stack multiple function calls

function iterativeBinarySearch (arr, x) { 
   
    let start = 0
    let end = arr.length-1; 
          
    // Iterate while start not meets end 
    while (start <= end){ 
  
        // Find the mid index 
        let mid = Math.floor((start + end)/2); 
   
        // If element is present at mid, return the position 
        if (arr[mid]=== x) return mid; 
  
        // Else look in left or right half accordingly 
        else if (arr[mid] < x)  
             start = mid + 1; 
        else
             end = mid - 1; 
    } 
    // If element is not found, return -1 (invalid position)
    return -1; 
} 
   
// Testing code
let arr = [1, 3, 5, 7, 8, 9]; 

// We'll try to find the number 5 in the array
let x = 5;    
const test1 = iterativeBinarySearch(arr, x, 0, arr.length-1)
console.log(test1)
// As we can see, it is in arr[2]

// Now, we'll try to find the number 6
x = 6;    
const test2 = iterativeBinarySearch(arr, x, 0, arr.length-1)
console.log(test2)
//As we can see, it is not on our array