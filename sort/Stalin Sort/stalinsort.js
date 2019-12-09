// Stalin sort is an "algorithm" that will look at a list and eliminate all the un-sorted numbers
// It returns the sorted, probably shorter, list
// Its advantage: it completes in linear time: O(n).
// Its disadvantage: it doesn't "really" sort as much as it eliminates the unsorted

function stalinSort(list) {
  if (!Array.isArray(list)) {
    throw new TypeError('You can only sort an Array!');
  }

  // We create a variable that will hold our sorted item
  // This guy is always sorted, always in the right order, everything starts with him
  let pivot;

  // We now filter the list and start looking at the all the items
  // by comparing each to the pivot item
  // We also update the pivot item every time we get to a new item that is in the right order
  return list.filter((item, idx) => {
    // At index 0, we have our pivot item, so we keep it in the list
    // If the current item is greater than or equal to the pivot item,
    // we update the pivot item for next time and we add the item to the list
    if (idx === 0 || item >= pivot) {
      pivot = item;
      return true;
    }

    // Anthing else is unsorted and should be discarded
    return false;
  });
}

// And now we can use it
// console.log(stalinSort([1,2,3,6,4,7]));
