/* 
Bozosort (Not to be confused with bogosort) is a sorting algorithm which sorts by randomly swapping two elements
See more: https://ece.uwaterloo.ca/~dwharder/aads/Algorithms/Sorting/Bozo_sort/
*/

function bozoSort(arr) {
  let copy = [...arr];
  let sorted = arr.sort();
  let runs = 0;

  while (!arrayEquals(sorted, copy)) {
    let index1 = Math.floor(Math.random() * arr.length);
    let index2 = Math.floor(Math.random() * arr.length);

    let temp = copy[index1];
    copy[index1] = copy[index2];
    copy[index2] = temp;

    runs += 1;
  }

  console.log(`It took ${runs} to sort the array!`);
  return copy;
}

function arrayEquals(a, b) {
  return (
    Array.isArray(a) &&
    Array.isArray(b) &&
    a.length === b.length &&
    a.every((val, index) => val === b[index])
  );
}
