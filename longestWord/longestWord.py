def longestWord(string):
    length =0
    lonWord = ""
    words = []
    stringList = string.split(" ")
    for word in stringList: #iterate over stringList array
        if len(word)> length: #check lengths
            words = []
            words.append(word)
            #lonWord = word
            length = len(word)
        elif len(word)== length:
            words.append(word)
    return ",".join(words)
print(longestWord(input("Enter a string: "))) #print longest word in string

            
        
