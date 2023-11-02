# Secret Emoji Language Encoder and Decoder

This Python script allows you to encode and decode messages using a secret emoji language. Each letter of the English alphabet is replaced with a corresponding emoji, making your messages fun and intriguing. Here's how you can use this code:

## Prerequisites

- Python 3.12 (or a compatible version)

## Usage

1. Clone or download the repository to your local machine.

2. Run the Python script by executing the following command:

    ```bash
    python secret_language_encoder_decoder.py
    ```

3. Follow the on-screen instructions to encode and decode messages.

## Functions

The script includes two main functions:

### `encode_message(message)`

This function takes an input message as a string and encodes it into the secret emoji language. It replaces English letters with corresponding emojis and leaves non-alphabetic characters unchanged.

### `decode_message(encoded_message)`

This function takes an encoded message in the secret emoji language and decodes it back into English letters. It performs a reverse lookup of the emojis and replaces them with the corresponding letters.

## Example

```python
# Input
message = "Hello, World!"

# Encoding the message
encoded = encode_message(message)
print("Encoded:", encoded)

# Decoding the encoded message
decoded = decode_message(encoded)
print("Decoded:", decoded)
```

The output would be:

```
Encoded: 😎🍔🍔🎈🎤, 🌍🍀🎯🎤!
Decoded: hello, world!
```

## Secret Language Dictionary

The secret language is defined in the `secret_language` dictionary, where each English letter maps to a unique emoji.

```python
secret_language = {
    'a': '😀',
    'b': '😌',
    # ... (other mappings) ...
    'z': '🌠'
}
```

You can customize this dictionary to create your own secret emoji language.

Feel free to use and modify this code for your own fun messages and applications!