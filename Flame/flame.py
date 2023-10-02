# Importing necessary modules
import numpy as np  # NumPy library for numerical operations
import itertools as it  # itertools module for creating iterators for efficient looping

# Main function that calculates FLAME relationship status
def main(name1, name2):
    # Empty list to store unique letters from both names
    unique_letters = []

    # Checking for unique letters in the first name
    for n in name1:
        # If the letter is not in the second name, add it to the unique letters list
        if n not in name2:
            unique_letters.append(n)

    # Checking for unique letters in the second name
    for n in name2:
        # If the letter is not in the first name, add it to the unique letters list
        if n not in name1:
            unique_letters.append(n)

    # FLAME game letters and corresponding relationship statuses
    game = "FLAME"
    game_list = ["FRIEND", "LOVE", "AFFECTION", "MARRIAGE", "ENEMY"]

    # Creating a zipped list of FLAME letters and statuses
    flame_status = zip(game, game_list)

    # Generating a sequence of numbers from 1 to the number of unique letters
    unique_letter_count = np.arange(1, len(unique_letters) + 1)

    # Looping through the unique letters and corresponding FLAME statuses
    for count, (letter, status) in zip(unique_letter_count, it.cycle(flame_status)):
        # If the count matches the number of unique letters, print the FLAME letter and status
        if len(unique_letters) == count:
            print(f"\nYou got the letter '{letter}' from FLAME.")
            print("Your relationship status is:", status)

# Entry point of the program
if __name__ == "__main__":
    # Getting input from the user for their name and their partner's name
    name1 = input("Enter Your Name: ")
    name2 = input("Enter Name of Your Partner: ")

    # Calling the main function with the input names
    main(name1, name2)
