def factorial(n):
    fact = 1
    for i in range(1, n+1):
        fact *= i
    return fact
 
def factorial_recursion(n):
    if (n == 0):
        return 1
    else:
        return n * factorial_recursion(n-1)

number = int(input("Enter a number: "))
if num < 0:
    print("Sorry, Factorial does not exist for negative numbers")
else:
    print("Factorial using Recursive Approach: ", factorial_recursion(number))
    print("Factorial using Iterative Approach: ", factorial(number))
