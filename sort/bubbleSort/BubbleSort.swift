import Foundation

public func bubbleSort<T> (_ elements: [T]) -> [T] where T: Comparable {
  return bubbleSort(elements, <)
}

public func bubbleSort<T> (_ elements: [T], _ comparison: (T,T) -> Bool) -> [T]  {
  var array = elements
  
  for i in 0..<array.count {
    for j in 1..<array.count-i {
      if comparison(array[j], array[j-1]) {
        let tmp = array[j-1]
        array[j-1] = array[j]
        array[j] = tmp
      }
    }
  }
  
  return array
}
