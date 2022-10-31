#Metodo da Bissecção
def f(x):
   f = x**2 + 4*x + 8
   return f
a = float(input("Insira a: "))
b = float(input("Insira b: "))
p = float(input("Insira a precisão: "))

if f(a)*f(b) < 0:
   x= (a+b)/2
   while (f(x)>p):
      if (f(a)*f(b)<0):
         a = x
      else:
         b = x
      x = (a+b)/2
   print("A raiz da função , com precisão de {} , é {}".format(p,x))
else:
   print("Não tem raiz no intervalo")
