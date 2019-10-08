import random

def sort(list, verbose=False):
    """ A horrible "sorting algorithm" that shuffles the list then check is its sorted if not shuffles again.
    There is no guarantee that it will ever finish """
    if verbose:
        print_list(list)

    while not isSorted(list):
        if verbose: 
            print("... not sorted. about to shuffle")
        random.shuffle(list)
        if verbose: 
            print_list(list)
    if verbose: print("... sorted!")
    else: 
        print_list(list)
        print() #newline
    
def isSorted(list):
    """ check in O(n) if the list is sorted """
    for i in range(len(list)-1):
        if list[i+1] < list[i]: 
            return False
    return True

def print_list(list):
    """ prints the list without a line break at the end """
    for i in list:
        print(i, end=" ")


if __name__ == "__main__":
    list = [1,3,4]
    sort(list, verbose=True)