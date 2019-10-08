num = int(input("How many fibonacci numbers do you want? "))
a=1
print(a)
b=1

print(b)
#1 1 2 3 5 8 13

for i in range(0,num-2):
    c =a+b
    print(c)
    a =b
    b =c
