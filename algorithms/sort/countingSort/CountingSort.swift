func countingSort(elements: inout [Int]) {
    var min = Int.max
    var max = Int.min
    
    for i in 0..<elements.count {
        if elements[i]<min {
            min = elements[i]
        }
        if elements[i]>max {
            max = elements[i]
        }
    }
    let range = max - min + 1
    var countingArray = [Int](repeating: 0, count: range)
    
    for i in 0..<elements.count {
        countingArray[elements[i]-min]+=1
    }
    var i = 0
    for (index, count) in countingArray.enumerated() {
        for _ in 0..<count {
            elements[i] = index+min
            i+=1
        }
    }
}

var array: [Int] = [1,6,2,6,4,3]
countingSort(elements: &array)
