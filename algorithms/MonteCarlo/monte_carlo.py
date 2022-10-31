import random
import math

dots = 2000000

print("We will generate a bunch of random numbers ({}) between 0 and 1. We are trying to reach Pi.\nThis algorithm was supposed to analize every x and y randomly created and count how many was inside a circle.\nLet's try!\n".format(dots))

runs = 0

def piFinder(dots):
    insideCircle = 0
    for i in range(dots):
        x = random.uniform(0, 1)
        y = random.uniform(0, 1)
        if math.sqrt(x*x + y*y) <= 1:
            insideCircle += 1
    AlmostPi = 4 * insideCircle / dots
    print("Run {}, the almostPi was: {}".format(runs + 1, AlmostPi))


while runs < 10:
    piFinder(dots)
    runs += 1

print("\nNow we gonna make a deal. You have to decide how many numbers will be created.\nRemember: larger numbers can give more precision, but we'll be more slow.")

def userDecides():
    global runs
    dots = int(input("\nTell me the amount of numbers that you want to create to know if it is inside the circle: "))
    piFinder(dots)
    runs +=1 
    tryAgain()

def tryAgain():
    userTryAgain = input("Do you want to try again? '1' for yes, '2' for no: ")
    if userTryAgain == '1':
        return userDecides()
    else:
        exit()

userDecides()
