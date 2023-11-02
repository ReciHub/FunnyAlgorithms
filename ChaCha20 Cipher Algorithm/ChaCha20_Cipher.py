from Crypto.Cipher import ChaCha20
from Crypto.Random import get_random_bytes

# Generate a random 256-bit key and a random 96-bit nonce
key = get_random_bytes(32)
nonce = get_random_bytes(12)

# Create a ChaCha20 cipher object
cipher = ChaCha20.new(key=key, nonce=nonce)

# The data to be encrypted
plaintext = b'This is a secret message.'

# Encrypt the data
ciphertext = cipher.encrypt(plaintext)

# To decrypt, you need to recreate the cipher object with the same key and nonce
cipher = ChaCha20.new(key=key, nonce=nonce)

# Decrypt the data
decrypted_data = cipher.decrypt(ciphertext)

print("Original Message:", plaintext)
print("Encrypted Message:", ciphertext)
print("Decrypted Message:", decrypted_data.decode())
