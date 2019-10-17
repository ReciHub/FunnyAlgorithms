amount = input ("How many numbers would you like? > ")
if (amount.isdigit()):
    amount=int(amount)

while (amount != "stop"):

    result = "0,1,"
    first = 0
    second = 1

    if amount == 0:
        print ()
    elif amount == 1:
        print ("0")
    else:

        for x in range(0, amount-2):
            num = first + second
            result = result + str(num) + ","
            first = second
            second = num
        print (result[0:-1])

    amount = input ("Type stop to exit \n How many numbers would you like? > ")
    if (amount.isdigit()):
        amount=int(amount)

