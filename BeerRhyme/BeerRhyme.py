# Here is the BeerRhyme game in python!!

beerNum = int(input())

word = "bottles"

while(beerNum>0):
    if(beerNum == 1):
        word = "bottle"
    print(f'{beerNum} {word} of beer on the wall')
    print(f'{beerNum} {word} of beer')
    print("Take one down.")
    print("Pass it around.")

    beerNum = beerNum - 1

    if(beerNum == 0):
        print("No more bottles on the wall")
    