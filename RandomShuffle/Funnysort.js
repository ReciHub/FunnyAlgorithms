function funnySort(arr) {
  console.log("Shuffling array using the 'Random Shuffle' algorithm...");
  arr.sort(() => Math.random() - 0.5);
  console.log("Oops! Array shuffled, but not really sorted! 😄");
}

let arr = [5, 2, 8, 1, 3];

console.log("Original array: " + arr.join(" "));

funnySort(arr);

console.log("Shuffled array: " + arr.join(" "));
