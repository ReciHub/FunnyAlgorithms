import string
#morse code dict
morse = {
        "a": ".-",
        "b": "-...",
        "c": "-.-.",
        "d": "-..",
        "e": ".",
        "f": "..-.",
        "g": "--.",
        "h": "....",
        "i": "..",
        "j": ".---",
        "k": "-.-",
        "l": ".-..",
        "m": "--",
        "n": "-.",
        "o": "---",
        "p": ".--.",
        "q": "--.-",
        "r": ".-.",
        "s": "...",
        "t": "-",
        "u": "..-",
        "v": "...-",
        "w": ".--",
        "x": "-..-",
        "y": "-.--",
        "z": "--..",
        "0": "-----",
        "1": ".----",
        "2": "..---",
        "3": "...--",
        "4": "....-",
        "5": ".....",
        "6": "-....",
        "7": "--...",
        "8": "---..",
        "9": "----."
    }

# inverse dict to make decryption
morse_inv = {v: k for k, v in morse.items()}

def encrypt(text):
    new_text = ""
    for i in range(len(text)):
        if(text[i] == ' ' or text[i] == '\n'):
            #tab to separate words
            new_text = new_text + "\t"
        #discard invalid characters from string
        elif(text[i] in string.ascii_letters or text[i] in string.digits):
            #spaces to separate letters
            new_text = new_text + morse[text[i].lower()] + " "
    #deletes last char(it will be a blank space because of the above operation)
    return str(new_text[:-1])

def decrypt(text):
    new_text = ""
    #replace tabs with 4 spaces for simplicity
    text = text.replace("\t","    ")
    #split words
    arr = text.split("    ")
    for i in range(len(arr)):
        #split chars from words
        splitted = arr[i].split(" ")
        
        #make sure that a real word is being analysed(we could be looking at an empty string)
        splitted[:] = [x for x in splitted if x]
        if(len(splitted) == 0):
            continue
            
        for j in range(len(splitted)):
            if(len(splitted[j]) > 0):   
                try:
                    #uses morse inverse dict
                    new_text = new_text + morse_inv[splitted[j]]
                except:
                    #if not in dict, morse code is invalid
                    return "Invalid Morse Code"
        new_text = new_text + " "
    return str(new_text[:-1])



print(encrypt("Hello, World"))
# .... . .-.. .-.. --- 	.-- --- .-. .-.. -..
print(decrypt(encrypt("Hello, World")))
# hello world
