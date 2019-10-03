// Bubble sort is a sorting algorithm that loops over a list and looks at each item
// If the current item is greater than the next item, we swap them and indicate a swap has occurred
// If at any point a swap occurred, we loop through the list again
// The entire process is repeated until we can complete a loop without making a swap

function bubbleSort(list) {
  if (!Array.isArray(list)) {
    throw new TypeError('You can only sort an Array!');
  }

  // We don't want to mutate the original list, so we make a copy of it
  const sorted = [...list];

  // The way we determine if a swapped has occurred is through a boolean flag
  // We flip this every time we make a swap or start a new iteration
  let swapped = false;

  // We need to iterate over the list at least once to determine if a swap has occurred
  do {
    // If we ever swapped in a previous iteration, let's make sure we start with a blank slate
    swapped = false;

    sorted.forEach((item, idx) => {
      if (item > sorted[idx + 1]) {
        // We now need to swap the two items in place
        // What this actually says is...take the item at idx and the item at idx + 1 and swap them
        [sorted[idx], sorted[idx + 1]] = [sorted[idx + 1], sorted[idx]];
        // It's equivalent to writing
        // let temp = item;
        // sorted[idx] = sorted[idx + 1];
        // sorted[idx + 1] = temp;

        // Since we swapped, we set the flag to true
        // And this will start the process again
        swapped = true;
      }
    });
  } while (swapped);

  // Finally we return the sorted list
  return sorted;
}

// And now we can use it
// console.log(bubbleSort([3,8,2,9,5,7,1,4]));
