def recur_factorial(n):
"""Function to return the factorial
   of a number using recursion"""
   if n == 1:
       return n
   else:
       return n*recur_factorial(n-1)
num=int(input()) #
if num < 0:
   print("Sorry, factorial does not exist for negative numbers")
elif num == 0:
   print("The factorial of 0 is 1")
else:
   print("The factorial of",num,"is",recur_factorial(num))