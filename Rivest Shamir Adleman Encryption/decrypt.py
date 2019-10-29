##
 # decrypt.py
 #
 # The decryption code for RSA implementation.
 # Takes ciphertext.txt from the same directory and /keys/private_key.txt to generate plaintext.txt.
 ##

# Square and Multiply modifed to handle modular exponentiation
def sam(b, e, n):
    exp = bin(e)
    val = b

    for i in range(3, len(exp)):
        val = ((val%n) * (val%n))%n
        if(exp[i:i+1] == '1'):
            val = ((val%n)*(b%n))%n
    return val

with open('keys/public_key.txt', 'r') as pk:
	# first line is e
	e = int(next(pk))
	# next is n
	n = int(next(pk))
with open('keys/private_key.txt', 'r') as pk:
	# first line is d
	d = int(next(pk))
with open('ciphertext.txt', 'r') as ct:
	# first line is ciphertext
	Y = int(next(ct))

X = sam(Y, d, n)
with open('plaintext.txt', 'w') as pt:
	pt.write('%d' % X)