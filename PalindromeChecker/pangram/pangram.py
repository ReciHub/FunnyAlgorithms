'''
The code is for checking whether a given input string is a "pangram", that is,
it contains all the letters from A to Z at least once. 
Assume the regular English alphabet of 26 letters. 
Any extra letters, numbers, punctuation etc are ignored.

Example:
Enter a string: the quick brown fox jumps over the lazy dog
The number is pangram!
'''

def pangram(s):
    l = len(s)
    letters = set()
    for char in s:
        if char.isalpha() == True:
            letters.add(char.lower())
    if len(letters) == 26:
        return True
    return False

str = input("Enter a string:")

result = pangram(str)

if(result == True):
    print("The number is pangram!")
else:
    print("Not a pangram!")

