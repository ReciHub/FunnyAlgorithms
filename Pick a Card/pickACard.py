import random

values = ['A', 'K', 'Q', 'J', '10', '9', '8', '7', '6', '5', '4', '3', '2']
suits = ["\u2663", "\u2665", "\u2666", "\u2660"]
#club = "\u2663"
#heart = "\u2665"
#diamond = "\u2666"
#spade = "\u2660"



card = [" -------", "| *     |", "| $     |", "|       |", "|     $ |", "|     * |",
" -------"]

cardValue = values[random.randrange(len(values))]
cardSuit = suits[random.randrange(len(suits))]

for i in card:
    i = i.replace('*', cardValue)
    i = i.replace('$', cardSuit)

    #remove and extra space in the case of ten (double digits)
    if cardValue == '10':
        if i[2] == '1':
            temp = list(i)
            del(temp[1])
            i = "".join(temp)
        elif i[6] == '1':
            temp = list(i)
            del(temp[8])
            i = "".join(temp)
    print(i)



