def convert(num, oldbase, newbase):
    deci = toDecimal(num, oldbase)
    return toBase(deci, newbase)

def toDecimal(num, oldbase):
    if oldbase == 10:
        return int(num)
    deci = 0
    for x in range(len(num)-1, 0):
        power = len(num)-1-x
        deci+=((num[x]-ord('0'))**(oldbase, power))
    return deci

def toBase(deci, newbase):
    if newbase == 10:
        return deci
    toRet = ""
    div = deci
    while div != 0:
        mod = div%newbase
        div = int(div/newbase)
        toRet=maxCheck(mod)+toRet
    return toRet

def maxCheck(num):
    if num > 9:
	    return chr(ord('7')+num)
    return chr(ord('0')+num)

inpNum = input("Enter the number you're converting: ")
base = 0
while base < 2 or base > 35:
    base = int(input("What base is this number in?\nEnter a number (2-35) here: "))
newBase = 0
while newBase < 2 or newBase > 35:
    newBase = int(input("What base is this number being converted to?\nEnter a number here: "))

print(convert(inpNum, base, newBase))