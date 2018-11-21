"""

This program takes a sorted array as input and
UNSORTs it into any random order

"""

from random import randrange

def unsort(Arr):
	New = []
	while( len(Arr) > 0):
		loc = randrange(len(Arr))
		New.append(Arr.pop(loc))
	return New
	
Arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print("  Orignal Array = ", Arr)
Arr = unsort(Arr)
print("Un-Sorted Array = ", Arr)
