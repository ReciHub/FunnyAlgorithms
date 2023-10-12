import Foundation

func checkEvenOrOdd(number: Int) -> String {
    if number % 2 == 0 {
        return "The number \(number) is even."
    } else {
        return "The number \(number) is odd."
    }
}

let number = 7
let result = checkEvenOrOdd(number: number)
print(result)
