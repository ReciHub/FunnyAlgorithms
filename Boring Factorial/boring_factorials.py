def power(x, y, p):
    res = 1
    x %= p
    while y > 0:
        if y & 1: res = (res * x) % p
        y = y >> 1
        x = (x * x) % p
    return res

def mod_inverse(a, p):
    # By fermat's theorem
    return power(a, p-2, p)

def mod_fact(n, p):
    if p <= n: return 0
    res = p - 1
    for i in range(n + 1, p):
        res = (res * mod_inverse(i, p)) % p
    return res

for _ in range(int(input())):
    n, p = map(int, input().split())
    print(mod_fact(n, p))
