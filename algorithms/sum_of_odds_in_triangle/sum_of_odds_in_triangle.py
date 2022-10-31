def rowSumOddNumbers(n):
    # The nth row starts with the number n^2-n+1 and then is an arithmetic 
    # sequence starting with that number and has lenght n, for a sum of
    # n^2-n+1 + n^2-n+3 + ... + n^2-n+2n-1 
    # = (n^2 + ... + n^2) - (n + ... + n) + (1 + 3 + ... + 2n-1)
    # = n^3 - n^2 + n^2 = n^3
    return n ** 3
