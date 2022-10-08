void main() {
  int target = 100;
  List<int> arr = [-1, 0, 4, 6, 11, 33, 53, 55];
  int leftP = 0;
  int rightP = arr.length - 1;
  search() {
    while (leftP <= rightP) {
      var mid = ((leftP + rightP) / 2).round();
      if (arr[mid] == target) {
        return mid;
      }
      if (target < arr[mid]) {
        rightP = mid - 1;
      } else {
        leftP = mid + 1;
      }
    }
    return -1; //not found target
  }

  print(search());
}
