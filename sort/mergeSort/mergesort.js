// Merge sort is a divide and conquer algorithm that uses recursion
// It divides a list into two halves: left and right
// And we call mergeSort on both of these until we get lists that contain less than 2 items
// We then walk back up and stitch these two lists and sort them at the same time
// using another function called merge, until we have one sorted list

function mergeSort(list) {
  if (!Array.isArray(list)) {
    throw new TypeError('You can only sort an Array!');
  }

  // If our list holds only one item (or none), then it's already sorted
  // This is also our base case
  if (list.length < 2) {
    return list;
  }

  // Now we can choose the pivot element and split the list into
  // the left half and the right half
  let pivotIdx = Math.floor(list.length / 2);
  let left = list.slice(0, pivotIdx);
  let right = list.slice(pivotIdx);

  // At this point, we need to merge the two lists
  // while sorting the items in each
  return merge(mergeSort(left), mergeSort(right));
}

// Merge will take the two lists, sort them and merge them back together
function merge(left, right) {
  // We need a new list where we can keep our sorted items
  let sorted = [];

  // We compare the first items in the two lists
  // And if the first item in the right list is bigger (or equal to the first item in the left),
  // we push it into the sorted list
  // If the first item in the left list is bigger
  // we push that into the sorted list
  // Naturally, we want to do this only if both the left and the right lists have items
  while (left.length && right.length) {
    // We're using the shift() method on the list which returns the first item in the list
    // and also removes that item from the list (hence the while loop)
    if (right[0] >= left[0]) {
      sorted.push(left.shift());
    } else {
      sorted.push(right.shift());
    }
  }

  // We could also get into the situation when one of the left or the right lists
  // is not empty, in which case, we need to push all the remaining items of that list
  // one by one into the sorted list and finally return a "mostly" sorted list
  return [...sorted, ...left, ...right];
}

// And now we can use it
// console.log(mergeSort([3,8,2,9,5,7,1,4]));
