n = input("Enter a word: ")

for i in range(len(n)):
    if n[i] != n[len(n) - 1 - i]:
        print("Word is not a palindrome!")
        break
else:
    print("Word is a palindrome!")
