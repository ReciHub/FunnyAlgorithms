secret_language = {
    'a': '😀',
    'b': '😌',
    'c': '🌟',
    'd': '💎',
    'e': '😏',
    'f': '🚀',
    'g': '🍀',
    'h': '🤫',
    'i': '😎',
    'j': '💯',
    'k': '🎉',
    'l': '🎈',
    'm': '🎁',
    'n': '🍔',
    'o': '🍕',
    'p': '🍦',
    'q': '🍭',
    'r': '🎶',
    's': '🎸',
    't': '🎤',
    'u': '😂',
    'v': '🏀',
    'w': '🏆',
    'x': '🎯',
    'y': '🌍',
    'z': '🌠'
}

# Function to encode a message
def encode_message(message):
    encoded_message = ""
    for char in message:
        if char.lower() in secret_language:
            encoded_message += secret_language[char.lower()]
        else:
            encoded_message += char
    return encoded_message

# Function to decode a message
def decode_message(encoded_message):
    decoded_message = ""
    i = 0
    while i < len(encoded_message):
        char = encoded_message[i]
        if char in secret_language.values():
            # Reverse lookup the character
            decoded_message += [key for key, value in secret_language.items() if value == char][0]
        else:
            decoded_message += char  # Not in the secret language
        i += 1
    return decoded_message

message=input("write a message to convert to secret emoji language: ")
encoded = encode_message(message)
print("Encoded:", encoded.encode('utf-8').decode('utf-8'))
decoded = decode_message(encoded)
print("Decoded:", decoded) 