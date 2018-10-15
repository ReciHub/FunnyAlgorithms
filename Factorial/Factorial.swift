import Foundation

while true {
    
    print("Enter a number to factorize")
    let x = Int(readLine()!)
    let number: Int = x!
    var fact: Int = 1
    
    let n: Int = number + 1
    
    for i in 1..<n{
        
        fact = fact * i
        
    }
    
    print("Factorial of ", number ," is", fact)
    
}
