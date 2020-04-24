
# Caesar cipher implemented over ASCII character set
MAX_KEY_SIZE = 256

def getMode():

    while True:

        print('Do you wish to encrypt or decrypt a message?')

        mode = input().lower()

        if mode in 'encrypt e decrypt d'.split():

            return mode

        else:

            print('Enter either "encrypt" or "e" or "decrypt" or "d".')

def getMessage():

    print('Enter your message:')

    return input()

def getKey():

    key = 0

    while True:

        print('Enter the key number (1-%s)' % (MAX_KEY_SIZE))

        key = int(input())

        if (key >= 1 and key <= MAX_KEY_SIZE):

            return key

def getTranslatedMessage(mode, message, key):

    if mode[0] == 'd':
        return Decrypt(message,key)
    elif mode[0] == 'e':
        return Encrypt(message, key)
    else:
        return "Wrong input"

mode = getMode()
message = getMessage()
key = getKey()

print('Your translated text is:')
print(getTranslatedMessage(mode, message, key))

def Encrypt(message, key):
    cipher_text = ''
    for i in message:
        cipher_text += str((ord(i)+key)%256)
    return cipher_text

def Decrypt(cipher_text, key):
    message = ''
    for i in cipher_text:
        message += str((ord(i)-key)%256)
    return message
        
