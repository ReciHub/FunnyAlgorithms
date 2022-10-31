#!/bin/python3

from random import randint

def swap(a, i, j):
    temp = a[i]
    a[i] = a[j]
    a[j] = temp

def shuffle(a):
    for i in range(2*len(a)):
        swap(a, randint(0, len(a)-1), randint(0, len(a)-1))

def isSorted(a):
    for i in range(1, len(a)):
        if a[i-1] > a[i]:
            return False
    return True

def bogoSort(a):
    while not isSorted(a):
        shuffle(a)
    return a

if __name__ == "__main__":
    a = [1, 4, 2, 8, 5, 7, 3, 6]
    bogoSort(a)
    print(a)
