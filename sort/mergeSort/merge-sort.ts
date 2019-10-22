function mergeSort(array: Array<number>) {
    if (array.length <= 1) {
      return array;
    }
  
    let middleIndex = Math.floor(array.length / 2);
  
    let leftArray = mergeSort(array.slice(0, middleIndex));
    let rightArray = mergeSort(array.slice(middleIndex, array.length));
  
    return merge(leftArray, rightArray);
  }
  
  function merge(leftPile: Array<number>, rightPile: Array<number>) {
    let sortedPile = [];
  
    let leftIndex = 0;
    let rightIndex = 0;
  
    while (leftIndex < leftPile.length && rightIndex < rightPile.length) {
      if (leftPile[leftIndex] < rightPile[rightIndex]) {
        sortedPile.push(leftPile[leftIndex]);
        leftIndex++;
      } else if (rightPile[rightIndex] < leftPile[leftIndex]) {
        sortedPile.push(rightPile[rightIndex]);
        rightIndex++;
      } else {
        sortedPile.push(leftPile[leftIndex]);
        leftIndex++;
  
        sortedPile.push(rightPile[rightIndex]);
        rightIndex++;
      }
    }
    while (leftIndex < leftPile.length) {
      sortedPile.push(leftPile[leftIndex]);
      leftIndex++;
    }
  
    while (rightIndex < rightPile.length) {
      sortedPile.push(rightPile[rightIndex]);
      rightIndex++;
    }
    return sortedPile;
  }
  