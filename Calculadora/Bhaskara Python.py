import math

a = float(input('a: '))
b = float(input('b: '))
c = float(input('c: '))

delta = b**2 - (4 * (a * c))
b1 = (-b + math.sqrt(delta)) / 2 * a
b2 = (-b - math.sqrt(delta)) / 2 * a

print()
print(f'''As raízes são:
Positiva: {b1}
Negativa: {b2}''')
