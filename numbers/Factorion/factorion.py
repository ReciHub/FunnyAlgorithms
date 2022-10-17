'''
A Factorion number is defined as a number in which the sum of the factorial
of the number digits is equals to the number
'''
import math

# Input a number to be check if it is a factorion
print("Enter a number:")
number = input()

# Sum the factorial of all the number digits
digits_sum = 0
for digit in number:
    digits_sum += math.factorial(int(digit))

# if sum of digits factorial is equals to the number, the number is a factorion
if digits_sum == int(number):
    print("{} is a factorion!".format(number))
else:
    print("{} is not factorion!".format(number))