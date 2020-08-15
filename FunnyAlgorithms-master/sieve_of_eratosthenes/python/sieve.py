def run_sieve(N, isPrime):
    for i in range(N+1):
        if isPrime[i]:
            for j in range(i+1, N+1):
                if j % i == 0:
                    isPrime[j] = False


def print_sieve(N, isPrime):
    for i in range(N+1):
        if isPrime[i]:
            print i,


def sieve(N):
    isPrime = [True] * (N+1)
    isPrime[0], isPrime[1] = False, False
    run_sieve(N, isPrime)
    print_sieve(N, isPrime)


sieve(int(input("Input size of sieve: ")))
