"""
Bozosort (Not to be confused with bogosort) is a sorting algorithm which sorts by randomly swapping two elements

See more: https://ece.uwaterloo.ca/~dwharder/aads/Algorithms/Sorting/Bozo_sort/
"""

import random
from typing import List
from copy import deepcopy


def bozo_sort(arr: List[int]):
    copy = deepcopy(arr)
    sorted_arr = sorted(arr)
    runs = 0

    while copy != sorted_arr:
        index1 = random.randint(0, len(arr) - 1)
        index2 = random.randint(0, len(arr) - 1)

        copy[index1], copy[index2] = copy[index2], copy[index1]
        runs += 1

    print(f"It took {runs} runs to sort the array!")
    return copy
