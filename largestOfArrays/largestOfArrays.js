function largestOfArr(arr) {
  var res = [];
  for (var n = 0; n < arr.length; n++) {
    var largestNum = arr[n][0];
    for (var sb = 1; sb < arr[n].length; sb++) {
      if (arr[n][sb] > largestNum) {
        largestNum = arr[n][sb];
      }
    }

    res[n] = largestNum;
  }

  return res;
}

largestOfArr([[5, 3, 4, 1], [18, 22, 13, 29], [35, 31, 41, 52], [1016, 100, 3540, 36]]);