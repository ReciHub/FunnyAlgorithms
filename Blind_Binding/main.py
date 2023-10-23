# The `import os` statement is importing the `os` module in Python. The `os` module provides a way to
# use operating system dependent functionality, such as clearing the console screen using
# `os.system('cls')` in Windows or `os.system('clear')` in Unix-like systems.
import os
#HINT: You can call clear() to clear the output in the console.
from art import logo
print(logo)
print("*First Bid First Serve*")
users = {}
run = True
while run:
  name = input("What is your name?: ")
  bid = float(input("What is your bid?: $"))
  users[name] = bid
  choice = input("Are there any other bidders? Type 'yes or 'no'.\n")
  if choice == 'yes':
    # `os.system('cls')` is a command that clears the console screen in Windows. It is used to remove
    # all the previous output from the console, providing a clean and clear interface for the user.
    os.system('cls')
    continue
  elif choice == 'no':
    run = False
    break
  else:
    print("You have entered wrong input, its game over.")
    run = False
    break

max_bid = 0
winner_name = ""
for key in users:
  if max_bid < users[key]:
    max_bid = users[key]
    winner_name = key


print(f"The winner is {winner_name} with a bid of ${max_bid}.")
