# Apresentar um algoritmo que tenha resolução por recursão
# Aplicar o teorema mestre para resolver a recorrência e estimar o custo do algoritmos

def gcd(x, y):
    if (y == 0):
        return x
    else:
        return gcd(y,x%y)

inp = input().split(" ")
x, y = (int (n) for n in (inp))

# No caso de "g" ser negativo, converter para positivo
g = gcd(x, y)
if (g < 0):
    g *= -1 # (- * -) = +

print(gcd(x,y))
