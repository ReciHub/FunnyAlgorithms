def sumPrimes(n):
    sum, sieve = 0, [True] * n
    for p in range(2, n):
        if sieve[p]:
            print(p,end=" ");
            sum += p
            for i in range(p*p, n, p):
                sieve[i] = False
    return sum

print sumPrimes(10)
