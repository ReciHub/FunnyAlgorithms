extension String {
    mutating func reverseString() {
        var reversedString = ""
        for var char in self{
            reversedString.insert(char, at: reversedString.startIndex)
        }
        self = reversedString
    }
}

// Use case
//var inputString = "saeed-rz"
//inputString.reverseString()
//print(inputString)
