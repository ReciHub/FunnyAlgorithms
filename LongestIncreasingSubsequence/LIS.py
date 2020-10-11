##
 # Program to find the length of the maximum increasing subsequence
 ##

import math

def binarySearch(item, pileTops, end):
    beg = 0
    while beg != end:
        m = int(math.floor((beg + end) / 2))
        if pileTops[m] < item:
            beg = m + 1
        else:
            end = m
    return beg

def lis(arr):
    pileTops = [0] * len(arr)
    size = 0
    for num in arr:
        index = binarySearch(num, pileTops, size)
        pileTops[index] = num
        size = max(index + 1, size)
    return size


input_arr = list()

with open('testLIS', 'r') as fp:
    inp_read = fp.read()

inp = inp_read.split("\n")
n = int(inp[0])

for num in inp[1].split(' '):
    input_arr.append(int(num))


print(lis(input_arr))

