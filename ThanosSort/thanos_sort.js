// function for testing if its sorted or not
is_sorted = array => {
  for (let i = 0; i < array.length; i++) {
    if (array[i - 1] > array[i]) return false;
    return true;
  }
};

//  loop over the array
// if array [ i -1] > array [i];
// return false
//return true

//function for thanos_sortings, takes in a universe arg

// test if the universe is sorted, return the universe

// SELECT HALF OF THE UNIVERSE RANDOMLY TO DIE

// size is the length of the universe
//
