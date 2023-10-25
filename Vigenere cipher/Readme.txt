
### History of the Vigenere Cipher:

The Vigenere cipher is a method of encrypting alphabetic text by using a simple form of polyalphabetic substitution. It was first described by Giovan Battista Bellaso in his 1553 book "La cifra del. Sig. Giovan Battista Bellaso," but it is named after Blaise de Vigenere, a French diplomat, who described a more complex variant in 1586.

The Vigenere cipher is an improvement over the Caesar cipher, which shifts all letters in the same way. Instead of using a single fixed shift, the Vigenere cipher uses a keyword to determine the shift for each letter. This makes it more secure and resistant to simple frequency analysis attacks.

### Description of the Python Code:

This Python code provides a basic implementation of the Vigenère cipher for educational purposes. It allows users to encrypt and decrypt messages using the Vigenere cipher. The code includes two functions:

1. vigenere_encrypt(plain_text, key): This function takes a plaintext and a key as input and returns the encrypted text using the Vigenere cipher.

2. vigenere_decrypt(encrypted_text, key): This function takes the encrypted text and the same key and returns the decrypted text.

To use the code, users can input a message and a key. The code then encrypts the message and decrypts it back using the key, demonstrating the Vigenere cipher's ability to both encode and decode messages.

This code is a simplified example meant for learning and understanding the basics of the Vigenere cipher. It is not suitable for secure encryption in real-world applications, as it lacks features like key validation and encryption mode selection. For security-critical applications, it is recommended to use established cryptographic libraries and practices.

Wish to get this commit merged and gain the hacktoberfest badges for this