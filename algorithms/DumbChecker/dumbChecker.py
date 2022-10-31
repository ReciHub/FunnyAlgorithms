import random

try:
    lucky_number = input("Enter your lucky number: ")
    lucky_number = int(lucky_number)
    random_number = round(random.random() * 100 + 10)
    print(f"You are {random_number}% dumb!")
except ValueError:
    print("Run again and enter a number dumbA**")
