import random

def is_sorted(arr):
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True

def bogo_sort(arr):
    while not is_sorted(arr):
        random.shuffle(arr)

# Example Usage:
my_list = [3, 2, 5, 1, 4]
print("Original List:", my_list)
bogo_sort(my_list)
print("Sorted List:", my_list)
