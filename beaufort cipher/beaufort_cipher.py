########################################################################
# BASED ON THE BEAUFORT SQUARE CREATED BY SIR FRANCIS BEAUFORT         #
########################################################################
#ALGORITHM BASED ON https://github.com/gary-mayfield/AOTW/blob/master/beaufort_cypher.py


from string import ascii_uppercase

dict1 = {char: i for i, char in enumerate(ascii_uppercase)}
dict2 = {i: char for i, char in enumerate(ascii_uppercase)}


def generate_key(message: str, key: str) -> str:
       
    x = len(message)
    i = 0
    while True:
        if x == i:
            i = 0
        if len(key) == len(message):
            break
        key += key[i]
        i += 1
    return key

def cipher_text(message: str, key_new: str) -> str:
       
    cipher_text = ""
    i = 0
    for letter in message:
        if letter == " ":
            cipher_text += " "
        else:
            x = (dict1[letter] - dict1[key_new[i]]) % 26
            i += 1
            cipher_text += dict2[x]
    return cipher_text

def original_text(cipher_text: str, key_new: str) -> str:
        
    or_txt = ""
    i = 0
    for letter in cipher_text:
        if letter == " ":
            or_txt += " "
        else:
            x = (dict1[letter] + dict1[key_new[i]] + 26) % 26
            i += 1
            or_txt += dict2[x]
    return or_txt


def main():
    message = "HELLO WORLD"
    key = "ABC"
    nkey = generate_key(message, key)
    cipher = cipher_text(message, nkey)
    print(f"Encrypted Text = {cipher}")
    print(f"Original Text = {original_text(cipher, nkey)}")


if __name__ == "__main__":
    main()