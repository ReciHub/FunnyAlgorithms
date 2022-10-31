# Program to demonstrate Hill Cipher Algorithm
# based on simple linear algebra: matrix operation
# assumption: the text is a 3 letter word

import random
import numpy as np

# creating a dict to map alphabet to number
alphabet_to_num = {'A':1, 'B':2, 'C':3, 'D':4, 'E':5, 'F':6, 'G':7, 'H':8, 'I':9, 'J':10, 'K':11, 'L':12, 'M':13,
'N':14, 'O':15, 'P':16, 'Q':17, 'R':18, 'S':19, 'T':20, 'U':21, 'V':22, 'W':23, 'X':24, 'Y':25, 'Z':26}


# list out keys and values separately
key_list = list(alphabet_to_num.keys())
val_list = list(alphabet_to_num.values())

# helper function to generate a 3x3 matrix key
def generate_key():
    keyMatrix = [[random.randint(1,26) for i in range(3)] for i in range(3)]
    return keyMatrix

# some preprocessing step
# this function requires 2 args: plain text and the generated key
# it converts both the list to numpy array
# and returns them
def hill_preprocess(plain_text, key):
    numeric_vector = []
    for i in range(0,3):
        numeric_vector.append(alphabet_to_num[plain_text[i]])

    # converting both list to numpy array for matrix multiplication operation
    numeric_vector = np.array(numeric_vector)
    # force it to be a column vector
    numeric_vector.shape = (3,1)
    # the key is a square matrix so doesn't matter
    key = np.array(key)
    return numeric_vector, key

#################################### Encryption ####################################
# the real encryption stuff is performed here
def hill_cipher_encrypt(numeric_vector, key):
    # applying the matrix operation
    tmp = key.dot(numeric_vector)
    tmp = np.mod(tmp, 26)
    encrypted = ""
    for i in range(0,3):
        encrypted += key_list[val_list.index(tmp[i])]
    return encrypted



#################################### Testing ####################################

# The message
print("Hill Cipher")
print("Plain text: ABC")

print("Applying encryption")
numeric_vector, key = hill_preprocess("ABC", generate_key())
encryption = hill_cipher_encrypt(numeric_vector, key)
print(encryption)
