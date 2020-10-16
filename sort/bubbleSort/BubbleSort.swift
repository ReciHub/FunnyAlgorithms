func bubbleSort(array: inout [Int]) {
    let n = array.count
    for i in 0..<n {
        var exchanges = 0
        for j in ((i+1)..<n).reversed() {
            if array[j] < array[j-1] {
                let tmp = array[j]
                array[j] = array[j-1]
                array[j-1] = tmp
                exchanges+=1
            }
        }
        if exchanges == 0 {
            break
        }
    }
}

var array = [1,6,2,4,3]
bubbleSort(array: &array)
print(array)
