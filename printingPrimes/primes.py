#!/usr/bin/env python3

# Golfed but efficient python prime generator using Sieve of Eratosthenes

# golfed code (101 bytes)
primes = \
    lambda m:(s:=[1]*m,[(i,[s.__setitem__(c,0)for(c)in range(i*i,m,i)])[0]for(i)in range(2,m)if s[i]])[1]

if __name__ == "__main__":
    print(f"Primes below 100:\n{', '.join(map(str,primes(100)))}")
