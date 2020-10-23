import random

# Function to check if array is sorted
def isSorted(arr):
    for x in range(len(arr) - 1):
        if(arr[x + 1] < arr[x]):
            return True
    return False

def random_sort(arr):
    temp = arr
    # Randomly shuffle until array is sorted
    while(isSorted(temp)):
        random.shuffle(temp)
    return temp

def main():
    # Testbench
    print(random_sort([8, 9, 3, 1, 4]))

main()