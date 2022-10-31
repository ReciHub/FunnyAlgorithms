# By @nsgwick
# Taken from https://github.com/nsgwick/VigenereCipher
import string

alphabet = string.ascii_uppercase


def of(C):
    return alphabet.index(C)


def encrypt(m, key):
    m = m.upper()
    key = key.upper()
    k = ""
    r = ""
    for i in range(len(m)):
        k += key[i % len(key)]
        r += alphabet[(of(m[i]) + of(k[i])) % len(alphabet)]
    return r


def decrypt(c, key):
    c = c.upper()
    key = key.upper()
    k = ""
    r = ""
    for i in range(len(c)):
        k += key[i % len(key)]
        r += alphabet[(of(c[i]) - of(k[i]) + len(alphabet)) % len(alphabet)]
    return r


if __name__ == '__main__':
    message = input("Message:")
    keyword = input("Keyword:")

    print("Encrypted: " + encrypt(message, keyword))
    print("Decrypted: " + decrypt(encrypt(message, keyword), keyword))
