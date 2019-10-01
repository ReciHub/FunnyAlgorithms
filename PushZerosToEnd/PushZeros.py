# Objective :
# Push all the zero’s of a given array to the end of the array. 
# The order of all other elements should be same.
# 
# For example :
# If the given arrays is 		{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
# Then it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
# 
# Time complexity is O(n) and Space complexity is O(1)

from typing import List

def pushZerosToEnd(arr: List[int], n: int):
    count = 0 # keep count of non-zero elements
    
    # Go through the list and assign the ith non-zero element to arr[count] and increment count 
    for i in range(n):
        if arr[i] != 0:
            arr[count] = arr[i]
            count += 1

    # Pad out the rest of the array with 0's
    # Note that count is now the index of the first 0
    while count < n:
        arr[count] = 0
        count += 1
    
    # This is O(1) space because it modifies the list 
    # in place rather than making a new list to return
