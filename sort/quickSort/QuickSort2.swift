func partition<T: Comparable>(_ elements: inout [T], _ low: Int, _ high: Int) -> Int {
    let pivot = high-1
    var i = low - 1
    for j in low..<pivot {
        if (elements[j] < elements[pivot]) {
            i+=1
            let tmp = elements[i]
            elements[i] = elements[j]
            elements[j] = tmp
        }
    }
    i+=1
    let tmp = elements[pivot]
    elements[pivot] = elements[i]
    elements[i] = tmp
    return i
}

func quickSort<T: Comparable>(_ elements: inout [T], _ low: Int, _ high: Int) {
    if high-low > 1 {
        let mid = partition(&elements, low, high)
        quickSort(&elements, low, mid)
        quickSort(&elements, mid+1, high)
    }
}

func quickSort<T: Comparable>(_ elements: inout [T]) {
    quickSort(&elements, 0, elements.count)
}

var array: [Int] = [1,6,2,4,3]
quickSort(&array)

