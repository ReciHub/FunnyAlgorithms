a, b = map(float, input("Initial Approximation (a, b) : ").split())
m = (a + b) / 2

def f(x): return x * x - 3

if f(a) * f(b) > 0:
    exit("\nYou have not assumed right a and b.")

while abs(f(m)) > 1E-5:
    if f(a) * f(m) < 0: b = m
    else: a = m
    m = (a + b) / 2

print("\nThe root is", round(m, 5))
