def fibonacci(number):
    if number <= 1:
        return 1
    return fibonacci(number - 1) + fibonacci(number - 2)

digit = int(input("Enter a position in the Fibonacci sequence: "))

print(fibonacci(digit))
