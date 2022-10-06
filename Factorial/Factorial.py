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
print("Fctorial using Recursion: ", factorial_recursion(number))
print("Fctorial using Iterative approach: ", factorial(number))
