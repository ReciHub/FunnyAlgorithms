import random
from time import sleep

lst = [1, 3, 2, 5, 4]
shuffles = 0

def shuffle(lst):
    random.shuffle(lst)

def isSorted(lst):
    for i in range(len(lst)-1):
        if lst[i] > lst[i+1]:
            return False
    return True;

while not isSorted(lst):
    shuffle(lst)
    shuffles += 1

print(lst, "is sorted after", shuffles, "shuffles")
