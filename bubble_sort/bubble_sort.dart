import 'dart:math';

void main() {
  //Genarates random 20 integers picking from 0-500 and add it to `arr` using `...` spread operator
  List<int> arr = [...List.generate(20, (_) => Random().nextInt(500))];
  List<int> arr1 = List.from(arr);

  _swap(int index1, int index2) {
    var temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  for (var i = 0; i < arr.length; i++) {
    for (var j = 1; j < arr.length; j++) {
      if (arr[j] < arr[j - 1]) _swap(j, j - 1);
    }
  }
  print('Array to sort - > $arr1');
  print('Sorted array  - > $arr');
}
