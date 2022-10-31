s = input("enter your text: ")
if len(s.split()) > 1:       # If the text is multi word, it will count the number of words
    n = len(s.split())
    print("your text contains " + str(n) + " words")
elif len(s.split()) == 1:    # If the text is one word, it will count the number of characters
    a = len(s.strip())
    print("your text contains " + str(a) + " characters")