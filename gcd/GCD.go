package main
import (
        "fmt"
)

func gcd(num1 int, num2 int) int {
    for num2 != 0 {
            temp := num2
            num2 = num1 % num2
            num1 = temp
    }
    return num1
}

func main() {
    var num1, num2 int
    fmt.Println("Enter two numbers: ")
    fmt.Scanln(&num1)
    fmt.Scanln(&num2)

    fmt.Printf("gcd of %d and %d is %d",num1,num2,gcd(num1, num2))
}
