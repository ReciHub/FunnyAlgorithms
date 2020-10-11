"""Sort question from mocking coding interview.
Given an array of integers arr where each element is at most k places away from its sorted position,
code an efficient function sortKMessedArray that sorts arr.
For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted
array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

"""

def sort_k_messed_array(arr, k):
    """We should pay attention to the fact that this array is almost sorted, and if k is small
    time complexity will be almost linear - O(k*n). Meanwhile for large numbers of k we should
    use QuickSort or MergeSort for better perfomance.

    Here is a selection sort.
    """

    if k == 0:
        return arr

    for i in range(len(arr)):
        min_index = find_min_index(arr, i, i + k)
        arr[i], arr[min_index] = arr[min_index], arr[i]

    return arr


def find_min_index(array, start, end):
    """Also pay attention for the end point - it could be more than len(array), because of this k-window"""

    min_val = array[start]
    min_index = start

    end = end + 1 if end < len(array) - 1 else len(array)

    for i in range(start, end):
        if array[i] < min_val:
            min_index = i
            min_val = array[i]

    return min_index

arr = [6,1,4,11,2,0,3,7,10,5,8,9]
k = 6

sorted_array = sort_k_messed_array(arr, k)
print(sorted_array == sorted(arr))