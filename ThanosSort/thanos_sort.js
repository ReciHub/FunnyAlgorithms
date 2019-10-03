isSorted = array => {
  for (let i = 1; i < array.length; i++) {
    if (array[i - 1] > array[i]) {
      return false;
    }
  }
  return true;
};

makeRandomUniverse = () => {
  // this needs to be refactored to have no duplicates
  let universe = [];
  for (var i = 0; i < 100; i++) {
    universe.push(Math.floor(Math.random() * 100 + 1));
  }
  console.log("Random universe", universe);
  return universe;
};

thanosSort = universe => {
  // Test if the universe is sorted, if it is, Thanos is happy, he returns the universe to its place.
  if (isSorted(universe)) console.log("SORTED Thanos is cool with this.");

  // Loop through the unsorted universe randomly, for 50% and remove them from the universe

  // Get half the universe
  let half = universe.length / 2;

  for (let i = 0; i < half; i++) {
    // randomly select a person/life form...remove them from the universe
    let randomPerson = universe.splice();
  }
};

let ourUniverse = makeRandomUniverse();

thanosSort(ourUniverse);
