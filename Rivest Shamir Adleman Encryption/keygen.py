##
 # keygen.py
 #
 # The key generator for RSA implementation.
 # Creates /keys/public_key.txt and /keys/private_key.txt which will be used by encrypt and decrypt programs.
 ##

import random

def gcd(a, b):
    while(b > 0):
        aa = a
        a = b
        b = aa%b
    return a

# Extended Eucledian Algorithm
def eec(e, n):
    ret = 0
    if(gcd(e,n) == 1):
        t = 1
        quot = e/n
        remd = e%n
        a = n
        
        while(remd > 0):
            temp = t-quot*ret
            t = ret
            ret = temp
            e = n
            n = remd
            quot = e/n
            remd = e%n
        ret%=a
        if(ret < 0): 
            ret += a
    return ret


# Miller-Rabin primality test
def try_composite(a, d, n, s):
    if pow(a, d, n) == 1:
        return False
    for i in range(s):
        if pow(a, 2**i * d, n) == n-1:
            return False
    return True

def is_prime(n):
    if n!=int(n):
        return False
    n=int(n)
    # initial few composites
    if n==0 or n==1 or n==4 or n==6 or n==8 or n==9:
        return False
 
    if n==2 or n==3 or n==5 or n==7:
        return True
    s = 0
    d = n-1
    while d%2==0:
        d>>=1
        s+=1
 
    for i in range(9):#number of trials 
        a = random.randrange(2, n)
        if try_composite(a, d, n, s):
            return False
 
    return True

def primegen():
    p_found = False
    q_found = False
    while(p_found == False):
        p = random.getrandbits(512)
        for i in range(20):
            p_found = is_prime(p)
            if(p_found == False):
                break
    
    while(q_found == False):
        q = random.getrandbits(513)
        for i in range(20):
            q_found = is_prime(q)
            if(q_found == False):
                break
    if(p == q):
        # we need distinct nums
        generate_prime()
    else:
        return p,q

# Returns the private key
def decrt_gen(exp,phi):
    private=eec(exp,phi)
    return private

# Returns the public key
def exp_gen(phi):
    g = 0
    flag = False
    while(g != 1 and flag == False):
        exp = random.randrange(1,phi-1)
        if(exp%2 != 0 and gcd(exp, phi) == 1):
            g = 1
            flag = True
        else:
            g = 0
            flag = False
    return exp


p,q = primegen()
phi = (p-1)*(q-1)
e = exp_gen(phi)
d = decrt_gen(e,phi)

n = p*q
# store e and n in public_key.txt
with open('keys/public_key.txt', 'w') as pk:
    pk.write("%d\n" % e)
    pk.write("%d\n" % n)

# store d in public_key.txt
with open('keys/private_key.txt', 'w') as pk:
    pk.write("%d\n" % d)