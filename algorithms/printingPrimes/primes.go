package main
import (
   "fmt"
   "os"
   "strconv"
)

func isPrime(n int) bool {
     if n < 2 {
	return false
     }
     for i:=2;i<=int(n/2);i++ {
	 if  n%i == 0 {
	     return false
	 }
     }
     return true
}

func printPrimes(n int) {
     for i:=1; i<=n; i++ {
       if isPrime(i) {
	  fmt.Printf("%d is a prime number\n",i)
       } else {
          fmt.Printf("%d is not a prime number\n",i)
       }
     }
}

func main() {
  fmt.Println("Enter a natural number")
   var number string
    _, err := fmt.Scanln(&number)
   if err != nil {
      fmt.Fprintln(os.Stderr, err)
      return
   }
   n, err := strconv.Atoi(number)
   if err != nil {
        fmt.Println(err)
        os.Exit(2)
   }
   fmt.Printf("Prime and Non-Prime numbers from 1 to %d\n",n)
   printPrimes(n)
}

