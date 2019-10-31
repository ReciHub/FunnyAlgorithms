// We'll write a recursive binary search function in javascript
// If the number searched is in the array, it'll return its position
// Otherwise, it'll return -1

function recursiveBinarySearch (arr, x, start, end) { 
       
    // Base Condition 
    if (start > end) return -1; 
   
    // Find the middle index 
    let mid = Math.floor((start + end)/2); 
   
    // Compare mid with given key x 
    if (arr[mid] === x) return x; 
          
    // If element at mid is greater than x, search in the left half of mid 
    if(arr[mid] > x)  {
      return recursiveBinarySearch(arr, x, start, mid-1); 
    }
    // If element at mid is smaller than x, search in the right half of mid 
    else{
      return recursiveBinarySearch(arr, x, mid+1, end); 
    }  
} 
   
// Testing Code
const arr = [1, 3, 5, 7, 8, 9]; 
// we'll look for number 5 in the array
let x = 5; 
   
console.log(recursiveBinarySearch(arr, x, 0, arr.length-1)) 
// now, we'll look for the number 6 is the array
x = 6; 
   
console.log(recursiveBinarySearch(arr, x, 0, arr.length-1)) 