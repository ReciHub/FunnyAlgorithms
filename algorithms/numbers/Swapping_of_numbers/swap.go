package main                                                                    
                                                                                
import "fmt"                                                                    
                                                                                
func main() {                                                                   
    var num1, num2 int                                                                                                        
    fmt.Scan(&num1)                                                                                                      
    fmt.Scan(&num2) 
    fmt.Printf("Before Swap num1= %d and num2= %d\n",num1,num2)
    num1, num2 = num2,num1   
    fmt.Printf("After Swap num1: %d and num2: %d\n", num1, num2)                
}   
