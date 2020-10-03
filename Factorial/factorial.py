def factorial(n):
    if n==0:
        return 1
    else:
        return n * factorial(n-1)
 
def factorial_recursion(n):
    if (n==0):
        return 1
    else:
        return n*factorial_recursion(n-1)

number = int(input("Enter a number: "))
print(factorial(number))
