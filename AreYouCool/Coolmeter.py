#Code by:Caio Cordeiro
#Github: github.com/CaioCordeiro
import random as ran
while True:
    x = int({{input}})
    i = 0
    lista =[]
    while(i!= x):
        value = ran.randrange(x+1)
        if value in lista:
            continue
        if value == 0 :
            continue
        lista.append(value)
        i = i+1
    posi = ran.randrange(x)
    if(lista[posi]>x/2):
        print("You are cool!")
    elif(lista[posi]<x/2):
        print("You are not cool!")
    else:
        print("You are the rarest kind of cool")
