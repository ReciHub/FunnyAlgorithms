generateRandomUniverse = () => {
  let randomUni = [];

  for (let i = 0; i < 100; i++) {
    let rando = Math.floor(Math.random() * 100) + 1;
    while (!randomUni.includes(rando)) {
      randomUni.push(rando);
    }
  }
  return randomUni;
};

isSorted = arr => {
  for (let i = 1; i < arr.length; i++) {
    if (arr[i - 1] > arr[i]) return false;
  }
  return true;
};

thanosSort = universe => {
  if (isSorted(universe)) return universe;

  let half = universe.length / 2;
  for (let i = 0; i < half; i++) {
    universe.splice(Math.floor(Math.random() * half) + 1, 1);
  }
  return universe;
};

let exampleUni = generateRandomUniverse();

thanosSort(exampleUni);
