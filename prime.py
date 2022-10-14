#Function that takes two numbers as input. Primer numbers will be evaluated between
#these two numbers.

def prime(x, y):
    prime_list = []
    for i in range(x, y):
        if i == 0 or i == 1:
            continue
        else:
            for j in range(2, int(i/2)+1):
                if i % j == 0:
                    break
            else:
                prime_list.append(i)
    return prime_list
 

xinit = 2 #starting_num
xfin = 11 #ending_num
listnum = prime(xinit, xfin)
if len(listnum) == 0:
    print("There are no prime numbers in this range")
else:
    print("The prime numbers in this range are: ", listnum)