from random import randint

#  heap sort

def build_max_heap(arr):
    length = len(arr)
    for i in range(int(length/2), -1, -1):
        max_heapify(arr, i, length)

    #  heap sort

    for i in range(length-1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        max_heapify(arr, 0, i)


def max_heapify(arr, i, heapSize):
    left = (2 * i) + 1
    right = (2 * i) + 2
    if left < heapSize and arr[left] > arr[i]:
        largest = left
    else:
        largest = i

    if right < heapSize and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        max_heapify(arr, largest, heapSize)


array = [randint(1, 100) for _ in range(20)]
print(array)
build_max_heap(array)
print(array)
