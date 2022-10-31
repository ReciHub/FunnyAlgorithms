Rivest Shamir Adleman
=====================
Deepraj Pandey
Oct 29, 2019

This is the README file for the barebones RSA implementation.


Key Generation
 - Create the directory `keys` in the directory where keygen.py resides.
 - Use the following command to run the key generator
     python keygen.py
 - It creates two files, namely, public_key.txt and private_key.txt in /keys. public_key.txt has two lines. First line is the encryption key (e in RSA) and the second line is n (product of the primes p and q - generated using the Miller Rabin Algo)

 Running time:
 #1    0.936s
 #2    0.806s
 #3    0.741s
 #4    0.913s
 #5    1.119s

 avg = 0.903s


 Encryption
 - Assumes that plaintext.txt is in the same directory and public_key.txt exists in /keys "in the same format as discussed in key generation".
 - Use the following command to run the encryption
     python encrypt.py
 - Generates the ciphertext in ciphertext.txt in the same directory as encrypt.py

 Decryption
  - Assumes that ciphertext.txt is in the same directory and public_key.txt and private_key.txt exist in /keys "in the format described in key generation"
 - Use the following command to run the decryption
     python decrypt.py
 - Generates the plaintext in plaintext.txt in the same directory as decrypt.py