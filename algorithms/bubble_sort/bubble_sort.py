def bubble_sort(arr):
    arr_len = len(arr)
    for i in range(arr_len-1):
        for j in range(0, arr_len-i-1):
            if arr[j] > arr[j + 1] :
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
 
arr = [64, 34, 25, 12, 22, 11, 90]
bubble_sort(arr)
 
print("The sorted array is:")
for i in range(len(arr)):
    print(f'{arr[i]}')