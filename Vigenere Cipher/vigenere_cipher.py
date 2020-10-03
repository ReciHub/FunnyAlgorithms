import string

mykey="PYTHON"
input_text="This Code Works"
code_text="IFBZ QBSC PVFXH"

# Alphabet used as reference (M)
# ABCDEFGHIJKLMNOPQRSTUVWXYZ
source = string.ascii_uppercase

# Key alphabet (K) shifted 1 position to the left
# BCDEFGHIJKLMNOPQRSTUVWXYZA
shift = 1
matrix = [ source[(i + shift) % 26] for i in range(len(source)) ]

def coder(thistext):
    ciphertext = []
    control = 0

    for x,i in enumerate(input_text.upper()):
        if i not in source: 
            #If the symbol is not in our reference alphabet, we simply print it
            ciphertext.append(i)
            continue
        else:
            #Wrap around the mykey string 
            control = 0 if control % len(mykey) == 0 else control 

            #Calculate the position C[i] = (M[i]+K[i]) mod len(M)
            result = (source.find(i) + matrix.index(mykey[control])) % 26

            #Add the symbol in position "result" to be printed later
            ciphertext.append(matrix[result])
            control += 1

    return ciphertext

def decoder(thistext):
    control = 0
    plaintext = []

    for x,i in enumerate(code_text.upper()):
        if i not in source: 
            #If the symbol is not in our reference alphabet, we simply print it
            plaintext.append(i)
            continue
        else:
            #Wrap around the mykey string 
            control = 0 if control % len(mykey) == 0 else control 

            #Calculate the position M[i] = (C[i]-K[i]) mod len(M)
            result = (matrix.index(i) - matrix.index(mykey[control])) % 26

            #Add the symbol in position "result" to be printed later
            plaintext.append(source[result])
            control += 1

    return plaintext

# Print results
print("Key: {0}".format(mykey))
print("\nDecode text:")
print("-> Input text: {0}".format(input_text))
print("-> Coded text: {0}".format(''.join(coder(input_text))))

# Print results
print("\nDecode text:")
print("-> Input text: {0}".format(code_text))
print("-> Decoded text: {0}".format(''.join(decoder(code_text)).lower()))