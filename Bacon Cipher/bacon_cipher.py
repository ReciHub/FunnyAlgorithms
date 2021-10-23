# The key of Bacon cipher
# here we are using the 26 key cipher and not the 24 where i,j and u,v have same keys
cipher_key = {'A':'aaaaa', 'B':'aaaab', 'C':'aaaba', 'D':'aaabb', 'E':'aabaa',
        'F':'aabab', 'G':'aabba', 'H':'aabbb', 'I':'abaaa', 'J':'abaab',
        'K':'ababa', 'L':'ababb', 'M':'abbaa', 'N':'abbab', 'O':'abbba',
        'P':'abbbb', 'Q':'baaaa', 'R':'baaab', 'S':'baaba', 'T':'baabb',
        'U':'babaa', 'V':'babab', 'W':'babba', 'X':'babbb', 'Y':'bbaaa', 'Z':'bbaab'}

def bacon_cipher_encrypt(plain_text):
    # converting the string to upper
    plain_text = plain_text.upper()
    # output
    op = ""
    for chr in plain_text:
        if chr in cipher_key:
            op += cipher_key[chr]
    return op

def bacon_cipher_decrypt(cipher_text):
    message = ""

    # creating lists for each keys and values
    key_list = list(cipher_key.keys())
    val_list = list(cipher_key.values())

    # splitting the text into 4-4 chunks
    for i in range(0, len(cipher_text) - 4, 5):
        # storing the sub array/ sub string into each element
        message += key_list[val_list.index(cipher_text[i:i+5])]

    return message

# testing
encryption = bacon_cipher_encrypt("HACKTOBERFEST")
print(encryption)
print(bacon_cipher_decrypt(encryption))
