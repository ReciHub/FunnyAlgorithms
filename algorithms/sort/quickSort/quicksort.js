// Quick sort is a divide and conquer algorithm that uses recursion
// It breaks down the array into smaller pieces and connects them at the end

function quickSort(list) {
  if (!Array.isArray(list)) {
    throw new TypeError('You can only sort an Array!');
  }

  // If our list holds only one item (or none), then it's already sorted
  // This is also our base case
  if (list.length < 2) {
    return list;
  }

  // Now we can choose the pivot element and split the list into
  // the half with elements less than the pivot,
  // and the half with elements greater than the pivot.
  // We choose the middle of the list as the pivot
  // But we could also choose the first or the last item as the pivot.
  // Choosing the right pivot will increase or decrease the complexity,
  // since the more pivots we choose as a result of the recursion, the larger our call stack
  let pivotIdx = Math.floor(list.length / 2);
  let pivot = list[pivotIdx];
  let lesser = [];
  let greater = [];

  // We loop over our list
  // If the current item in the list is not our pivot
  // We push either in the greater or lesser list
  // Depending on whether the current item is greater than or lesser than our pivot
  for (let i in list) {
    // We're going to add our pivot at the end, so we don't need to add it here
    // And because i is a string and pivotIdx is a number, we use != instead of !==
    if (i != pivotIdx) {
      list[i] > pivot ? greater.push(list[i]) : lesser.push(list[i]);
    }
  }

  // As a final step, we return a new list that combines
  // the items that result when calling quickSort on the lesser,
  // the pivot,
  // and the items that result when calling quickSort on the greater,
  // giving us a sorted list at the end.
  return [
    ...quickSort(lesser),
    pivot,
    ...quickSort(greater)
  ];
}

// And now we can use it
// console.log(quickSort([3,8,2,9,5,7,1,4]));
