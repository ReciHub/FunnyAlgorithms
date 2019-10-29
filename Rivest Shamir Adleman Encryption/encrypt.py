##
 # encrypt.py
 #
 # The encryption code for RSA implementation.
 # Takes plaintext.txt from the same directory and /keys/public_key.txt to generate ciphertext.txt.
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
with open('plaintext.txt', 'r') as pt:
	# first line is plaintext
	X = int(next(pt))

Y = sam(X, e, n)
with open('ciphertext.txt', 'w') as ct:
	ct.write('%d' % Y)