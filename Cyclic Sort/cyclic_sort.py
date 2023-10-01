def cyclic_sort(arr):
    n = len(arr)
    i = 0
    while i < n:
        correct = arr[i] - 1
        if arr[i] != arr[correct]:
            arr[i], arr[correct] = arr[correct], arr[i]
        else:
            i =i+ 1

# Usage example:
if __name__ == "__main__":
    arr = [3, 1, 5, 4, 2]
    cyclic_sort(arr)
    print(arr)